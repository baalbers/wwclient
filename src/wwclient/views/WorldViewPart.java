//package wwclient.views;
//
//import java.util.Iterator;
//
//import gov.nasa.worldwind.Model;
//import gov.nasa.worldwind.WorldWind;
//import gov.nasa.worldwind.avlist.AVKey;
//import gov.nasa.worldwind.event.SelectEvent;
//import gov.nasa.worldwind.geom.LatLon;
//import gov.nasa.worldwind.geom.Position;
//import gov.nasa.worldwind.layers.Layer;
//import gov.nasa.worldwind.layers.LayerList;
//import gov.nasa.worldwind.layers.TerrainProfileLayer;
//import gov.nasa.worldwind.layers.ViewControlsLayer;
//import gov.nasa.worldwind.layers.ViewControlsSelectListener;
//import gov.nasa.worldwind.layers.placename.PlaceNameLayer;
//import gov.nasa.worldwind.swt.WorldWindowSWTGLCanvas;
////import gov.nasa.worldwindx.examples.util.HighlightController;
////import gov.nasa.worldwindx.examples.util.ToolTipController;
//
//import javax.media.opengl.GLContext;
//import org.eclipse.swt.SWT;
//import org.eclipse.swt.opengl.GLData;
//import org.eclipse.swt.widgets.Composite;
//import org.eclipse.ui.part.ViewPart;
//
//import wwclient.utils.HighlightController;
//import wwclient.utils.ToolTipController;
//
//public class WorldViewPart extends ViewPart {
//
//	public static final String ID = "wwclient.WorldViewPart";
//
//	private static WorldWindowSWTGLCanvas worldWindow;
//	
//    protected ToolTipController toolTipController;
//    protected HighlightController highlightController;
//	/**
//	 * The constructor.
//	 */
//	public WorldViewPart() {
//	}
//
//	@Override
//	public void createPartControl(Composite parent) {
//		GLData data = new GLData();
//		data.doubleBuffer = true;
//		GLContext context = null;
//		worldWindow = (WorldWindowSWTGLCanvas) WorldWindowSWTGLCanvas.create(parent, SWT.NONE, data, context);
//		Model m = (Model) WorldWind.createConfigurationComponent(AVKey.MODEL_CLASS_NAME);
////		m.getLayers().add(new StatusLayer());
//		worldWindow.setModel(m);
//		
//		// Add Terrain Profiler
//        TerrainProfileLayer tp = new TerrainProfileLayer();
//        tp.setEventSource(worldWindow);
//        tp.setStartLatLon(LatLon.fromDegrees(0, -10));
//        tp.setEndLatLon(LatLon.fromDegrees(0, 65));
//        tp.setFollow(TerrainProfileLayer.FOLLOW_CURSOR);
//        worldWindow.getModel().getLayers().add(tp);
//        
//        ViewControlsLayer viewCntrlLayer = new ViewControlsLayer();
//		viewCntrlLayer.setPosition("NORTHWEST");
//        worldWindow.addSelectListener(new ViewControlsSelectListener(worldWindow, viewCntrlLayer));
//		worldWindow.getModel().getLayers().add(viewCntrlLayer);
//        
//        //Disable Compass and Terrain Profile by default
//        Iterator<Layer> it = worldWindow.getModel().getLayers().iterator();
//        while(it.hasNext()){
//        	Layer l = it.next();
//        	if(l.getName().equals("Compass"))
//        		l.setEnabled(false);
//        	else if(l.getName().equals("Terrain profile graph"))
//        		l.setEnabled(false);
//        }
//        
//        // Add controllers to manage highlighting and tool tips.
//        this.toolTipController = new ToolTipController(worldWindow, AVKey.DISPLAY_NAME, null);
//        this.highlightController = new HighlightController(worldWindow, SelectEvent.ROLLOVER);
//	}
//	
//	@Override
//	public void setFocus() {
//		if (worldWindow == null || worldWindow.isDisposed()) {
//			return;
//		}
//
//		worldWindow.setFocus();
//	}
//	
//	public void moveToLocation(Position location) {
//        if (location == null)
//            return;
//        worldWindow.getView().goTo(location, 363985.60);
//        worldWindow.redraw();
//    }
//	
//	public void repaint() {
//		worldWindow.redraw();
//    }
//	
//	public WorldWindowSWTGLCanvas getWorldWindow() {
//		return worldWindow;
//	}
//	
//	/**
//	 * Insert the layer into the layer list just before the placenames.
//	 * @param layer
//	 */
//    public void insertBeforePlacenames(Layer layer) {
//        int compassPosition = 0;
//        LayerList layers = worldWindow.getModel().getLayers();
//        for (Layer l : layers)
//        {
//            if (l instanceof PlaceNameLayer)
//                compassPosition = layers.indexOf(l);
//        }
//        layers.add(compassPosition, layer);
//    }
//    
//	/**
//	 * Returns all available Layers from the WorldWindow Model
//	 * @return Layers as a <b>LayerList</b>
//	 */
//	public LayerList getLayers() {
//		return worldWindow.getModel().getLayers();
//	}
//}
