package wwclient.utils.geotiff;

import gov.nasa.worldwind.WorldWind;
import gov.nasa.worldwind.avlist.*;
import gov.nasa.worldwind.data.*;
import gov.nasa.worldwind.exception.WWRuntimeException;
import gov.nasa.worldwind.geom.Extent;
import gov.nasa.worldwind.geom.Sector;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.render.DrawContext;
import gov.nasa.worldwind.render.Renderable;
import gov.nasa.worldwind.util.*;
import gov.nasa.worldwindx.examples.analytics.AnalyticSurface;
import gov.nasa.worldwindx.examples.analytics.AnalyticSurfaceAttributes;
import gov.nasa.worldwindx.examples.analytics.AnalyticSurfaceLegend;
import gov.nasa.worldwindx.examples.util.ExampleUtil;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;

import javax.swing.SwingUtilities;

public class GeoTiffParser {
	protected static final double HUE_BLUE = 240d / 360d;
	protected static final double HUE_RED = 0d / 360d;

	public static void createSurface(String path, final RenderableLayer outLayer) {
		outLayer.setValue("isTimelineLayer", true);
		
		BufferWrapperRaster raster = loadRasterElevations(path, outLayer);

		if (raster == null)
			return;

		double[] extremes = WWBufferUtil.computeExtremeValues(raster.getBuffer(), raster.getTransparentValue());
		if (extremes == null)
			return;


		final AnalyticSurface surface = new AnalyticSurface();
		surface.setSector(raster.getSector());
		surface.setDimensions(raster.getWidth(), raster.getHeight());
		surface.setValues(AnalyticSurface.createColorGradientValues(
				raster.getBuffer(), raster.getTransparentValue(), extremes[0], extremes[1], HUE_BLUE, HUE_RED));
		System.out.println("TransparentValue: "+raster.getTransparentValue());
		System.out.println("extremes[0]: "+extremes[0]);
		System.out.println("extremes[1]: "+extremes[1]);
		System.out.println("test: "+5e3);
		surface.setVerticalScale(1000);//5e3
//		surface.setAltitudeMode(WorldWind.RELATIVE_TO_GROUND);
		surface.setAltitudeMode( (Integer) outLayer.getValue("AltitudeModel") );
		//        surface.setAltitude();

		AnalyticSurfaceAttributes attr = new AnalyticSurfaceAttributes();
		attr.setDrawOutline(false);
		attr.setDrawShadow(false);
		attr.setInteriorOpacity(0.6);
		surface.setSurfaceAttributes(attr);

		Format legendLabelFormat = new DecimalFormat("# m")
		{
			public StringBuffer format(double number, StringBuffer result, FieldPosition fieldPosition)
			{
				System.out.println("Value: "+number);
				double valueInFeet = number ;//* WWMath.METERS_TO_FEET;
				return super.format(valueInFeet, result, fieldPosition);
			}
		};

		final AnalyticSurfaceLegend legend = AnalyticSurfaceLegend.fromColorGradient(extremes[0], extremes[1],
				HUE_BLUE, HUE_RED,
				AnalyticSurfaceLegend.createDefaultColorGradientLabels(extremes[0], extremes[1], legendLabelFormat),
				AnalyticSurfaceLegend.createDefaultTitle(outLayer.getName()));
		legend.setOpacity(0.8);
		legend.setScreenLocation(new Point(100, 300));

		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				surface.setClientLayer(outLayer);
				outLayer.addRenderable(surface);
				outLayer.addRenderable(createLegendRenderable(surface, 300, legend));
			}
		});
	}

	protected static BufferWrapperRaster loadRasterElevations(String path, RenderableLayer outLayer) {
		// Download the data and save it in a temp file.
		File file = new File(path);
//		File file = ExampleUtil.saveResourceToTempFile(path, "." + WWIO.getSuffix(path));
        //TODO: Layer Name from filename
        outLayer.setName(file.getName());
        
		// Create a raster reader for the file type.
		DataRasterReaderFactory readerFactory = (DataRasterReaderFactory) WorldWind.createConfigurationComponent(
				AVKey.DATA_RASTER_READER_FACTORY_CLASS_NAME);
		DataRasterReader reader = readerFactory.findReaderFor(file, null);

		// Before reading the raster, verify that the file contains elevations.
		try {
			AVList metadata = reader.readMetadata(file, null);
			if (metadata == null || !AVKey.ELEVATION.equals(metadata.getStringValue(AVKey.PIXEL_FORMAT)))
			{
				String msg = Logging.getMessage("ElevationModel.SourceNotElevations", file.getAbsolutePath());
				Logging.logger().severe(msg);
				throw new IllegalArgumentException(msg);
			}
			// Read the file into the raster.
			DataRaster[] rasters = reader.read(file, null);
			if (rasters == null || rasters.length == 0)
			{
				String msg = Logging.getMessage("ElevationModel.CannotReadElevations", file.getAbsolutePath());
				Logging.logger().severe(msg);
				throw new WWRuntimeException(msg);
			}

			// Determine the sector covered by the elevations. This information is in the GeoTIFF file or auxiliary
			// files associated with the elevations file.
			Sector sector = (Sector) rasters[0].getValue(AVKey.SECTOR);
			if (sector == null)
			{
				String msg = Logging.getMessage("DataRaster.MissingMetadata", AVKey.SECTOR);
				Logging.logger().severe(msg);
				throw new IllegalArgumentException(msg);
			}

			// Request a sub-raster that contains the whole file. This step is necessary because only sub-rasters
			// are reprojected (if necessary); primary rasters are not.
			int width = rasters[0].getWidth();
			int height = rasters[0].getHeight();

			DataRaster subRaster = rasters[0].getSubRaster(width, height, sector, rasters[0]);

			// Verify that the sub-raster can create a ByteBuffer, then create one.
			if (!(subRaster instanceof BufferWrapperRaster))
			{
				String msg = Logging.getMessage("ElevationModel.CannotCreateElevationBuffer", path);
				Logging.logger().severe(msg);
				throw new WWRuntimeException(msg);
			}

			return (BufferWrapperRaster) subRaster;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * @param surface
	 * @param surfaceMinScreenSize
	 * @param legend
	 * @return
	 */
	protected static Renderable createLegendRenderable(final AnalyticSurface surface, final double surfaceMinScreenSize,
			final AnalyticSurfaceLegend legend)
	{
		return new Renderable()
		{
			public void render(DrawContext dc)
			{
				Extent extent = surface.getExtent(dc);
				if (!extent.intersects(dc.getView().getFrustumInModelCoordinates()))
					return;

				if (WWMath.computeSizeInWindowCoordinates(dc, extent) < surfaceMinScreenSize)
					return;

				legend.render(dc);
			}
		};
	}
}
