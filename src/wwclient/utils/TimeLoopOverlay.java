package wwclient.utils;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import wwclient.utils.TimeSeriesLayer.OverlayListener;
import wwclient.views.WorldWindAWTViewPart;

import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import gov.nasa.worldwind.layers.Layer;
import gov.nasa.worldwind.layers.RenderableLayer;
//import gov.nasa.worldwind.swt.WorldWindowSWTGLCanvas;

public class TimeLoopOverlay extends RenderableLayer implements OverlayListener {
	
	private CopyOnWriteArrayList<TimeSeriesLayer> overlays 	= new CopyOnWriteArrayList<TimeSeriesLayer>(); 
	
    /** A thread used to flip layer visibility */
	private Worker worker = null;
    private Thread animator = null;
    private WorldWindowGLCanvas canvas = null;
    private int animationSpeed;
	// Animation loop status listeners
    private CopyOnWriteArrayList<GroundOverlayLoopListener> listeners = new CopyOnWriteArrayList<GroundOverlayLoopListener>(); 
    	

    // An interface to receive animation step updates
    static public interface GroundOverlayLoopListener extends OverlayListener {
    	void statusChanged(final int current, final int total, final TimeSeriesLayer layer);
    }
    
    public TimeLoopOverlay(String name, WorldWindowGLCanvas canvas, int animationSpeed) {
    	super();
    	this.canvas = canvas;
    	super.setName(name);
    	this.animationSpeed = animationSpeed;
    	worker = new Worker(overlays, canvas, animationSpeed);
    }
    
    public void add(TimeSeriesLayer overlay) {
    	overlay.setEnabled(false);
    	overlay.addOverlayListener(this);
    	this.overlays.add(overlay);
    	
    }
    
    public synchronized void setVisible(TimeSeriesLayer layer, boolean visible) {
    	if(worker == null) return;
    	
    	if(!visible) {
    		worker.hiddenOverlays.add(layer);
    	} else {
    		worker.hiddenOverlays.remove(layer);
    	}
    }
        
    private void play() {
    	if(canvas==null || overlays == null ) return;
    	worker = new Worker(overlays, canvas, animationSpeed);
    	worker.hiddenOverlays.clear();
    	worker.setLoopListeners(listeners);
    	
    	if ( animator != null ) return;
    	
    	animator = new Thread(worker);
    	animator.start();
    }
    
    public void stop() {   	
    	if( worker != null ) 
    		worker.stop();
    	setAllEnabled(false);
    	
    	animator = null;
    	worker	 = null;
    }
    
    private void setAllEnabled(boolean enabled) {
    	for(TimeSeriesLayer layer : overlays) {
    		layer.setEnabled(enabled);
    	}
    }
    
    public void setEnabled(boolean enabled) {
    	if ( enabled ) play();
		else stop();
    }
    
    public void pause() {
    	if(worker != null) worker.pause();
    }
    
    public void resume() {
    	//play();
    	if(worker != null) worker.resume();
    }
    
    // Thread to control animation by manipulating layer visibility
    static private class Worker implements Runnable {
    	
    	CopyOnWriteArrayList<TimeSeriesLayer> overlays;
    	CopyOnWriteArrayList<TimeSeriesLayer> hiddenOverlays = new CopyOnWriteArrayList<TimeSeriesLayer>();
    	// For loop status updates
    	private CopyOnWriteArrayList<GroundOverlayLoopListener> listeners;
    	
    	// used to add layers & repaint canvas
        private WorldWindowGLCanvas canvas;
        
    	// Visible frame. Only 1 frame is visible at a given time
        private int visibleFrame = 0;
    	private long interval = 50000;
    	// animation speed: 0..100
    	private int speed;
    	private boolean paused = false;
    	private boolean done = false;
    	
    	public Worker(CopyOnWriteArrayList<TimeSeriesLayer> overlays, WorldWindowGLCanvas canvas, int speed) {
    		this.overlays = overlays;
    		this.canvas = canvas;
    		this.speed = speed;
    		
		}
    	
    	@SuppressWarnings("unused")
		void removeListeners(GroundOverlayLoopListener listener) {
    		listeners.remove(listener);
    	}
    	void setLoopListeners (CopyOnWriteArrayList<GroundOverlayLoopListener> listeners) {
    		this.listeners = listeners;
    	}
    	
    	/* notify listeners of a loop update */
    	void statusChanged (int current, int total, TimeSeriesLayer layer) {
    		Iterator<GroundOverlayLoopListener> iter = listeners.iterator();
    		
    		while ( iter.hasNext()) {
    			iter.next().statusChanged(current, total , layer );
			}
    	}
    	
		@Override
		public void run() {
			System.out.println("Worker run() called with Speed: "+speed);
			done = false;
			TimeSeriesLayer layer;
			do {
				final long sleep = interval/getSpeed();
    			setAllEnabled(false);
    			
    			layer = overlays.get(visibleFrame);
    			if (!hiddenOverlays.contains(layer)) {
    				
    				// make visible
    				layer.setEnabled(true);
    				
    				statusChanged(visibleFrame + 1, overlays.size(), layer);
    				
    				try {
		    			Thread.sleep(sleep);
		    			// check if loop is paused
	    				if(paused) {
	    					while(paused) {
	    						try {
	    							// when paused sleep for 1 sec and check again if paused
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									done = true;
									e.printStackTrace();
								}
	    					}
	    				}
		    			
					} catch (InterruptedException e) {
						done = true;
					}
    				// make invisible
    				layer.setEnabled(false);
    				
    				canvas.redraw();
    			}
    			// make next layer visible
    			if(!done) {
    				visibleFrame++;
    			}
    			if ( visibleFrame > overlays.size() - 1 ) {
    				visibleFrame = 0;
    			}
			} while (!done);
		}
		
		private void setAllEnabled (boolean enabled) {
    		for ( TimeSeriesLayer overlay : overlays) {
    			overlay.setEnabled(enabled);
    		}
    	}
		
		/**
		 * Pauses the Worker until resume() is called
		 */
		private synchronized void pause () {
    		//done = true;
			paused = true;
    	}
		
		/**
		 * When 
		 */
		private synchronized void resume() {
			if(paused) {
				paused = false;
			} else {
				System.out.println("Worker not paused.");
			}
			
		}

    	private synchronized void stop () {
    		// signal thread completion
    		done = true;
    		
			// thread done (reset)
    		visibleFrame = 0;
    	}
    	
    	@SuppressWarnings("unused")
		private synchronized void setSpeed (int speed) {
    		this.speed = speed;
    	}

		private int getSpeed() {
			return speed;
		}
		
		@SuppressWarnings("unused")
		private long getSleepInterval () {
			return interval/getSpeed();
		}
    	
    }

	@Override
	public void onError(Layer layer, Exception ex) {
		for(GroundOverlayLoopListener listener : listeners) {
			listener.onError(layer, ex);
		}
		
	}
	
	public CopyOnWriteArrayList<TimeSeriesLayer> getOverlays(){
		return overlays;
	}
}
