package wwclient.utils;

import gov.nasa.worldwind.layers.Layer;

import java.util.ArrayList;

import org.eclipse.jface.viewers.CheckboxTableViewer;

//import wwclient.views.WorldViewPart;
import wwclient.views.WorldWindAWTViewPart;

public class LayerAnimationThread extends Thread{
	
	private CheckboxTableViewer layers;
	private ArrayList<Layer> timelineLayers;
	private WorldWindAWTViewPart view;
	private boolean stop = false;
	
	public LayerAnimationThread(CheckboxTableViewer layers, ArrayList<Layer> timelineLayers, WorldWindAWTViewPart view) {
		this.layers = layers;
		this.timelineLayers = timelineLayers;
	}

	public void run() {
		System.out.println("LayerAnimationThread startet!");
		if(stop == false) {
			for (Layer l: timelineLayers) {
				if(stop) break;
				l.setEnabled(true);
				layers.setChecked(l, true);
				view.repaint();
				try {
					sleep(5000);	//TODO: set the time dynamically
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

}
