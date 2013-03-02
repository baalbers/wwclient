package wwclient.views;

import gov.nasa.worldwind.Configuration;
import gov.nasa.worldwind.Model;
import gov.nasa.worldwind.WorldWind;
import gov.nasa.worldwind.avlist.AVKey;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import gov.nasa.worldwind.event.SelectEvent;
import gov.nasa.worldwind.geom.Angle;
import gov.nasa.worldwind.geom.LatLon;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.CompassLayer;
import gov.nasa.worldwind.layers.Layer;
import gov.nasa.worldwind.layers.LayerList;
import gov.nasa.worldwind.layers.TerrainProfileLayer;
import gov.nasa.worldwind.layers.ViewControlsLayer;
import gov.nasa.worldwind.layers.ViewControlsSelectListener;
import gov.nasa.worldwind.layers.placename.PlaceNameLayer;
import gov.nasa.worldwindx.examples.util.HighlightController;
import gov.nasa.worldwindx.examples.util.ToolTipController;

import java.awt.BorderLayout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class WorldWindAWTViewPart extends ViewPart {

	public static final String ID = "wwclient.WorldWindAWTViewPart";
	private static WorldWindowGLCanvas world;
	private Composite top;

	public static ToolTipController toolTipController;
	public static HighlightController highlightController;
	/**
	 * Initialize the default WW layers
	 */
	static {
		initWorldWindLayerModel();
	}


	public WorldWindAWTViewPart() {

	}

	@Override
	public void createPartControl(Composite parent) {
		// Build GUI: top(SWT)->Frame(AWT)->Panel(AWT)->WorldWindowGLCanvas(AWT)
		top = new Composite(parent, SWT.EMBEDDED);
		//		top.setLayoutData(new GridData(GridData.FILL_BOTH));
		top.setLayout(new FillLayout());


		java.awt.Frame worldFrame = SWT_AWT.new_Frame(top);
		java.awt.Panel panel = new java.awt.Panel(new java.awt.BorderLayout());

		worldFrame.add(panel);
		panel.add(world, BorderLayout.CENTER);

		worldFrame.requestFocus();

		// max parent widget
		parent.setLayoutData(new GridData(GridData.FILL_BOTH));

	}

	/*
	 * Initialize WW model with default layers
	 */
	static void initWorldWindLayerModel ()
	{
		// Set initial position to ~Osnabrück/Münster
		Configuration.setValue(AVKey.INITIAL_LATITUDE, 52);
		Configuration.setValue(AVKey.INITIAL_LONGITUDE, 8);

		world = new WorldWindowGLCanvas();
		Model m = (Model) WorldWind.createConfigurationComponent(AVKey.MODEL_CLASS_NAME);

		// Add Position Layer
		//m.getLayers().add(new PositionLayer(world));


		m.setShowWireframeExterior(false);
		m.setShowWireframeInterior(false);
		m.setShowTessellationBoundingVolumes(false);

		world.setModel(m);

		// Remove CompassLayer
		for(Layer l : world.getModel().getLayers()) {
			if (l.getClass() == CompassLayer.class) {
				world.getModel().getLayers().remove(l);
			}
		}
		// Add View Controls
		ViewControlsLayer viewCntrlLayer = new ViewControlsLayer();
		viewCntrlLayer.setPosition("NORTHWEST");
		world.addSelectListener(new ViewControlsSelectListener(world, viewCntrlLayer));
		world.getModel().getLayers().add(viewCntrlLayer);

		// Add Terrain Profiler
		TerrainProfileLayer tp = new TerrainProfileLayer();
		tp.setEventSource(world);
		tp.setStartLatLon(LatLon.fromDegrees(0, -10));
		tp.setEndLatLon(LatLon.fromDegrees(0, 65));
		tp.setFollow(TerrainProfileLayer.FOLLOW_CURSOR);
		tp.setEnabled(false);
		world.getModel().getLayers().add(tp);


		// Add controllers to manage highlighting and tool tips.
		toolTipController = new ToolTipController(world, AVKey.DISPLAY_NAME, null);
		highlightController = new HighlightController(world, SelectEvent.ROLLOVER);

	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
	}

	public static void repaint() {
		world.redraw();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	/**
	 * Returns all available Layers from the WorldWindow Model
	 * @return Layers as a <b>LayerList</b>
	 */
	public LayerList getLayers() {
		return world.getModel().getLayers();
	}

	/**
	 * Insert the layer into the layer list just before the placenames.
	 * @param layer
	 */
	public void insertBeforePlacenames(Layer layer) {
		int compassPosition = 0;
		LayerList layers = world.getModel().getLayers();
		for (Layer l : layers)
		{
			if (l instanceof PlaceNameLayer)
				compassPosition = layers.indexOf(l);
		}
		layers.add(compassPosition, layer);
	}

	public WorldWindowGLCanvas getWorldWindow() {
		return world;
	}
}
