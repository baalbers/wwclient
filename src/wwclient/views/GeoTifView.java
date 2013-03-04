package wwclient.views;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import wwclient.Activator;
import wwclient.utils.*;
import wwclient.utils.geotiff.*;
import gov.nasa.worldwind.WorldWind;
import gov.nasa.worldwind.layers.LayerList;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.ui.part.ViewPart;

import wwclient.views.WorldWindAWTViewPart;


public class GeoTifView extends ViewPart {

	public GeoTifView() {
	}

	private FormToolkit formToolkit;
	private ScrolledForm form;
	private CheckboxTableViewer layers;

	private WorldWindAWTViewPart worldview;

	private Section sctnGetGeoTif;
	private Text txtGeoTiffsurl;
	
	private Button btnRemoveSelectedLayer;
	private Button btnRemoveAllLayer;

	private Combo comboAltitudeModel;
	private int altitudeModel;		// holds the selected AltitudeModel for the loaded Layer

	private Scale scale;			// scale to navigate between the timeseries layer
	private Label lblSelectedLayer;	// shows the selected TimeseriesLayer
	// animation stuff
	private Button btnAnimate;
	private Button btnPauseAnimation;
	private Combo comboSpeed;
	private boolean animate = false;
	private boolean paused = false;
	private TimeLoopOverlay overlay;


	public void createPartControl(Composite parent) {
		formToolkit = new FormToolkit(parent.getDisplay());
		form = formToolkit.createScrolledForm(parent);
		TableWrapLayout layout = new TableWrapLayout();
		form.getBody().setLayout(layout);


		worldview = (WorldWindAWTViewPart) Activator.getView(getViewSite().getWorkbenchWindow(), WorldWindAWTViewPart.ID);

		/**
		 * GetCapabilities Section
		 */
		sctnGetGeoTif = formToolkit.createSection(form.getBody(), Section.TWISTIE | Section.TITLE_BAR | Section.EXPANDED);
		sctnGetGeoTif.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP, 1, 1));
		formToolkit.paintBordersFor(sctnGetGeoTif);
		sctnGetGeoTif.setText("Load GeoTiff as Layer");

		Composite compositeGeoTiff = formToolkit.createComposite(sctnGetGeoTif, SWT.NONE);
		sctnGetGeoTif.setClient(compositeGeoTiff);
		compositeGeoTiff.setLayout(new GridLayout(3, false));

		txtGeoTiffsurl = formToolkit.createText(compositeGeoTiff, "", SWT.LEFT);
		txtGeoTiffsurl.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		txtGeoTiffsurl.setText("/home/bastian/java/data/geotiff/prec01_16_germany.tif");
		//		txtGeoTiffsurl.setText("/Volumes/Macintosh HD/Users/bastian/Desktop/wfs/prec_16_tif/prec_12_16_ger.tif");

		Button btnGetCap = formToolkit.createButton(compositeGeoTiff, "Load as Layer", SWT.CENTER);
		btnGetCap.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				loadButtonClicked();
			}
			public void widgetDefaultSelected(SelectionEvent event) {
				loadButtonClicked();
			}
		});

		Button btnLoadFolder = new Button(compositeGeoTiff, SWT.NONE);
		formToolkit.adapt(btnLoadFolder, true, true);
		btnLoadFolder.setText("Load Folder");
		btnLoadFolder.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				loadFolderButtonClicked();
			}
			public void widgetDefaultSelected(SelectionEvent event) {
				loadFolderButtonClicked();
			}
		});
		new Label(compositeGeoTiff, SWT.NONE);

		Label lblAltitudeModel = new Label(compositeGeoTiff, SWT.NONE);
		formToolkit.adapt(lblAltitudeModel, true, true);
		lblAltitudeModel.setText("Altitude Model:");

		comboAltitudeModel = new Combo(compositeGeoTiff, SWT.NONE);
		comboAltitudeModel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		formToolkit.adapt(comboAltitudeModel);
		formToolkit.paintBordersFor(comboAltitudeModel);
		// These are the possible Altitude Models for Layer
		comboAltitudeModel.add("CLAMP_TO_GROUND");
		comboAltitudeModel.add("RELATIVE_TO_GROUND");
		comboAltitudeModel.add("ABSOLUTE");
		comboAltitudeModel.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				int selection = comboAltitudeModel.getSelectionIndex();

				switch (selection) {
				case 0:  altitudeModel = WorldWind.CLAMP_TO_GROUND;
				break;
				case 1: altitudeModel = WorldWind.RELATIVE_TO_GROUND;
				break;
				case 2: altitudeModel = WorldWind.ABSOLUTE;
				break;
				default: altitudeModel = WorldWind.RELATIVE_TO_GROUND;
				break;
				}
			}
		});
		comboAltitudeModel.select(1);
		new Label(compositeGeoTiff, SWT.NONE);

		/**
		 * 
		 *  Section --- Layer Manager ---
		 *  
		 */
		Section sctnLayer = formToolkit.createSection(form.getBody(), Section.TWISTIE | Section.TITLE_BAR | Section.EXPANDED);
		sctnLayer.setLayoutData(new TableWrapData(TableWrapData.FILL, TableWrapData.TOP, 1, 1));
		formToolkit.paintBordersFor(sctnLayer);
		sctnLayer.setText("GeoTiff Layer");

		Composite compositeLayers = formToolkit.createComposite(sctnLayer);
		TableWrapLayout layoutLayers = new TableWrapLayout();
		layoutLayers.numColumns = 3;
		compositeLayers.setLayout(layoutLayers);
		TableWrapData td = new TableWrapData(TableWrapData.FILL_GRAB);
		td.colspan = 3;
		Table tableLayers = formToolkit.createTable(compositeLayers, SWT.CHECK | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tableLayers.setLayoutData(td);

		sctnLayer.setClient(compositeLayers);

		layers = new CheckboxTableViewer(tableLayers);
		
		btnRemoveSelectedLayer = new Button(compositeLayers, SWT.NONE);
		formToolkit.adapt(btnRemoveSelectedLayer, true, true);
		btnRemoveSelectedLayer.setText("Remove selected Layers");
		// enabled when a layer is selected!
		btnRemoveSelectedLayer.setEnabled(false);
		btnRemoveSelectedLayer.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				Object[] elems = layers.getCheckedElements();
				removeLayers(elems);
			}
			public void widgetDefaultSelected(SelectionEvent event) {
				Object[] elems = layers.getCheckedElements();
				removeLayers(elems);
			}
		});
		
		btnRemoveAllLayer = new Button(compositeLayers, SWT.NONE);
		formToolkit.adapt(btnRemoveAllLayer, true, true);
		btnRemoveAllLayer.setText("Remove all Layers");
		// enable when there are any layers
		btnRemoveAllLayer.setEnabled(false);
		btnRemoveAllLayer.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				layers.setAllChecked(true);
				Object[] elems = layers.getCheckedElements();
				removeLayers(elems);
			}

			public void widgetDefaultSelected(SelectionEvent event) {
				layers.setAllChecked(true);
				Object[] elems = layers.getCheckedElements();
				removeLayers(elems);
			}
		});
		
		// executed when a layer is selected in the layers table
		layers.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				TimeSeriesLayer layer = (TimeSeriesLayer) event.getElement();
				layer.setEnabled(event.getChecked());
				// repaint globe
				worldview.repaint();
				// enable removing layer
				btnRemoveSelectedLayer.setEnabled(true);
			}
		});

		/***
		 *  
		 *  Section Timeseries controls (Navigation etc.)
		 *  
		 */
		Section sctnTimeseriesControl = formToolkit.createSection(form.getBody(), Section.TWISTIE | Section.TITLE_BAR | Section.EXPANDED);
		sctnTimeseriesControl.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP, 1, 1));
		sctnTimeseriesControl.setText("Timeseries Navigation");

		Composite compositeControls = formToolkit.createComposite(sctnTimeseriesControl, SWT.NONE);
		sctnTimeseriesControl.setClient(compositeControls);
		compositeControls.setLayout(new GridLayout(2, false));


		Button btnUp = new Button(compositeControls, SWT.NONE);
		btnUp.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		formToolkit.adapt(btnUp, true, true);
		btnUp.setText("^");
		btnUp.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				upButtonClicked();
			}
			public void widgetDefaultSelected(SelectionEvent event) {
				upButtonClicked();
			}
		});

		lblSelectedLayer = formToolkit.createLabel(compositeControls, "Selected Layer:", SWT.NONE);
		lblSelectedLayer.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		new Label(compositeControls, SWT.NONE);


		scale = new Scale(compositeControls, SWT.FILL);
		scale.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, false, 1, 1));
		scale.setIncrement(1);
		scale.setPageIncrement(1);
		scale.setEnabled(false);

		// Show Layer when selected with scale-slider 
		scale.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				// da scales contiuous sind, muss nach jedem 
				// select event auf- bzw. abgerundet werden!
				int scaleValue = scale.getSelection();
				// update the scale selection
				scale.setSelection(scaleValue);
				showSelectedLayer(scale.getSelection());
			}
		});

		Button btnDown = new Button(compositeControls, SWT.NONE);
		btnDown.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		formToolkit.adapt(btnDown, true, true);
		btnDown.setText("v");
		new Label(compositeControls, SWT.NONE);
		btnDown.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				downButtonClicked();
			}
			public void widgetDefaultSelected(SelectionEvent event) {
				downButtonClicked();
			}
		});
		//new Label(compositeControls, SWT.NONE);
		/**
		 * Animation Section
		 */
		// Set up the Animation Layer for WorldWind
		worldview = (WorldWindAWTViewPart) Activator.getView(getViewSite().getWorkbenchWindow(), WorldWindAWTViewPart.ID);
//		overlay = new TimeLoopOverlay("Animated Layer", worldview.getWorldWindow(), 80);

		Section sctnOptions = formToolkit.createSection(form.getBody(), Section.TWISTIE | Section.TITLE_BAR | Section.EXPANDED);
		sctnOptions.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP, 1, 1));
		sctnOptions.setText("Timeseries Animation");

		Composite compositeOptions = formToolkit.createComposite(sctnOptions, SWT.NONE);
		sctnOptions.setClient(compositeOptions);
		compositeOptions.setLayout(new GridLayout(2, false));

		Label lblAnimationSpeed = formToolkit.createLabel(compositeOptions, "", SWT.NONE);
		lblAnimationSpeed.setText("Animation Speed: ");

		comboSpeed = new Combo(compositeOptions, SWT.NONE);
		formToolkit.adapt(comboSpeed);
		for(int i = 0; i<=100; i+=10) {
			comboSpeed.add(Integer.toString(i));
		}
		comboSpeed.select(8);
		comboSpeed.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
//				overlay = new TimeLoopOverlay("Animated Layer", worldview.getWorldWindow(), Integer.valueOf(comboSpeed.getItem(comboSpeed.getSelectionIndex())));
				System.out.println(comboSpeed.getItem(comboSpeed.getSelectionIndex()));
			}
		});


		// Button to start the Animation
		btnAnimate = new Button(compositeOptions, SWT.NONE);
		btnAnimate.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		formToolkit.adapt(btnAnimate, true, true);
		btnAnimate.setText("Start Animation");
		btnAnimate.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				animate = !animate;
				animateTimlineLayers();
			}
			public void widgetDefaultSelected(SelectionEvent event) {
				animate = !animate;
				animateTimlineLayers();
			}
		});

		btnPauseAnimation = new Button(compositeOptions, SWT.NONE);
		btnPauseAnimation.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		formToolkit.adapt(btnPauseAnimation, true, true);
		btnPauseAnimation.setText("Pause Animation");
		btnPauseAnimation.setEnabled(false);
		btnPauseAnimation.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				paused = !paused;
				pauseAnimation();
			}
			public void widgetDefaultSelected(SelectionEvent event) {
				paused = !paused;
				pauseAnimation();
			}
		});
	}

	public void setFocus() {

	}

	/**
	 * Loads single File to the Layertable
	 */
	private void loadButtonClicked() {

		TimeSeriesLayer layer = new TimeSeriesLayer();
		layer.setPickEnabled(false);
		// set the altitude model
		layer.setValue("AltitudeModel", altitudeModel);
		worldview.insertBeforePlacenames(layer);
		GeoTiffParser.createSurface(txtGeoTiffsurl.getText(), layer);

		addLayerToTable(layer);
	}

	/**
	 * Loads a bulk of Files from a given Folder
	 */
	private void loadFolderButtonClicked() {
		File folder = new File(txtGeoTiffsurl.getText());
		File[] listOfFiles = folder.listFiles();
		Arrays.sort(listOfFiles);
		for (int i = 0; i < listOfFiles.length; i++) {
			File f = listOfFiles[i];
			if (f.isFile()) {
				TimeSeriesLayer layer = new TimeSeriesLayer();
				layer.setPickEnabled(false);
				// set the altitude model
				layer.setValue("AltitudeModel", altitudeModel);
				worldview.insertBeforePlacenames(layer);
				GeoTiffParser.createSurface(f.getPath(), layer);

				addLayerToTable(layer);
			}
		}
	}

	/**
	 * Add the given Layer to the LayersTable and update Scale Maximum
	 * @param layer
	 */
	public void addLayerToTable(TimeSeriesLayer layer) {
		layer.setEnabled(false);
		layers.add(layer);
		layers.setChecked(layer, layer.isEnabled());
		TableItem item = layers.getTable().getItem(layers.getTable().getItems().length-1);
		item.setText(layer.getName());

		scale.setMaximum(layers.getTable().getItems().length);
		scale.setEnabled(true);
		
		btnRemoveAllLayer.setEnabled(true);
	}
	
	/**
	 * 
	 * @param elems
	 */
	private void removeLayers(Object[] layerlist) {
		// remove each Layer from the WorldWind Model
		for(Object o : layerlist) {
			TimeSeriesLayer l = (TimeSeriesLayer) o;
			worldview.getLayers().remove(l);
			
		}
		// and remove them from the layers table
		layers.remove(layerlist);
		// update gui
		int length = layers.getTable().getItems().length;
		scale.setMaximum(length);
		btnRemoveSelectedLayer.setEnabled(false);
		// when there are no more layers
		if (length <= 0) {
			scale.setEnabled(false);
			btnRemoveAllLayer.setEnabled(false);
			lblSelectedLayer.setText("Selected Layer: None");
		}
	}

	/**
	 * Updates the Layer Table and Scale when the Up-Button is clicked
	 */
	private void upButtonClicked() {
		// when there is a next layer to show 
		if (scale.getSelection() < layers.getTable().getItems().length) {
			int newValue = scale.getSelection()+1;
			// update scale and show next layer
			scale.setSelection(newValue);
			showSelectedLayer(newValue);
		}
	}

	/**
	 * Updates the Layer Table and Scale when the Down-Button is clicked
	 */
	private void downButtonClicked() {
		// when there is a next layer to show 
		if (scale.getSelection() > 0 && layers.getTable().getItems().length > 0) {
			int newValue = scale.getSelection()-1;
			// update scale and show next layer
			scale.setSelection(newValue);
			showSelectedLayer(newValue);;
		}
	}

	/**
	 * Shows the selected Layer and updates the layerCheckedState, Label and WorldView
	 * @param selection Nr. of Layer in layers (-Table)
	 */
	private void showSelectedLayer(int selection) {
		// array starts with 0
		int realselection = selection-1;
		// get the WorldView
		//		WorldViewPart view = (WorldViewPart) Activator.getView(getViewSite().getWorkbenchWindow(), WorldViewPart.ID);
		LayerList layerList = worldview.getLayers();
		ArrayList<TimeSeriesLayer> timelineLayers = new ArrayList<TimeSeriesLayer>();
		// set all elements in our layers table to enabled=false
		layers.setAllChecked(false);
		// get all TimeLine layer
		for (int j = 0; j < layerList.size(); j++) {
			if (layerList.get(j).getValue("isTimelineLayer") != null) {
				timelineLayers.add((TimeSeriesLayer) layerList.get(j));
				layerList.get(j).setEnabled(false);
			}
		}
		// check if there is a layer to show
		if(realselection <= timelineLayers.size()-1 && realselection >= 0) {
			TimeSeriesLayer l = timelineLayers.get(realselection);
			l.setEnabled(true);
			lblSelectedLayer.setText("Selected Layer: "+l.getName());
			layers.setChecked(l, true);
			worldview.repaint();
			// when there is no layer to show
		} else {
			lblSelectedLayer.setText("Selected Layer: None");
		}

	}

	private boolean btnRemoveSelectedLayersState;	// used to check if button should be enabled again
	/**
	 * Shows each TimelineLayer for a specific time
	 */
	private void animateTimlineLayers() {
		// only animate layers when there are any!
		if(layers.getTable().getItems().length > 0) {
			if(animate) {
				// TEST TODO
				overlay = new TimeLoopOverlay("Animated Layer", worldview.getWorldWindow(), Integer.valueOf(comboSpeed.getItem(comboSpeed.getSelectionIndex())));
				// TEST END
				btnPauseAnimation.setEnabled(true);
				btnAnimate.setText("Stop Animation");
				LayerList layerList = worldview.getLayers();
				// Get all TimeLineLayers from WorldWind
				for (int j = 0; j < layerList.size(); j++) {
					if (layerList.get(j).getValue("isTimelineLayer") != null) {
						// and add them to the TimeLoopOverlay Layer
						overlay.add((TimeSeriesLayer) layerList.get(j));
					}
				}
				// start animation
				overlay.setEnabled(true);
				lblSelectedLayer.setText("Selected Layer: Animating all Layers");
				// update gui
				btnRemoveSelectedLayersState = btnRemoveSelectedLayer.getEnabled();
				btnRemoveSelectedLayer.setEnabled(false);
				btnRemoveAllLayer.setEnabled(false);
				
			} else { // stop animation
				btnPauseAnimation.setEnabled(false);
				btnAnimate.setText("Start Animation");
				overlay.stop();
				overlay = null;
				
				// update gui
				btnRemoveSelectedLayer.setEnabled(btnRemoveSelectedLayersState);
				btnRemoveAllLayer.setEnabled(true);
			}	
		}
	}
	
	/**
	 * Pause Animation
	 */
	private void pauseAnimation() {
		if(paused) {
			overlay.pause();
			btnPauseAnimation.setText("Animation Paused");
		} else {
			overlay.resume();
			btnPauseAnimation.setText("Pause Animation");
		}
	}
}
