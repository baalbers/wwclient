package wwclient.utils;

import java.util.Vector;

import gov.nasa.worldwind.layers.Layer;
import gov.nasa.worldwind.layers.RenderableLayer;

public class TimeSeriesLayer extends RenderableLayer {
	// Animation loop status listeners
    private Vector<OverlayListener> listeners = new Vector<OverlayListener>();
    
	/** Ground overlay status messages */
	static public interface OverlayListener
	{
		public void onError ( Layer layer, Exception ex);
	}
	
//	@Override
//	protected void doRender(DrawContext dc) {
//		// TODO Auto-generated method stub
//		
//	}
	
//    public String toString()
//    {
//    	return getName();
//    }
	
	/**
	 * Add an overlay status listener
	 * @param listener
	 */
	public void addOverlayListener( OverlayListener listener){
		listeners.add(listener);
	}

	public void removeOverlayListener( OverlayListener listener){
		listeners.remove(listener);
	}
	
//	/**
//	 * Notify listeners of a Layer error
//	 */
//	@SuppressWarnings("unused")
//	private void onError (TimeSeriesLayer layer, Exception ex) {
//		
//		for (OverlayListener listener : listeners) {
//			listener.onError(layer, ex);
//		}
//	}

}
