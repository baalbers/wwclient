package wwclient.views;

import java.util.ArrayList;

import gov.nasa.worldwind.layers.LayerList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.ui.part.ViewPart;

import wwclient.Activator;
import wwclient.utils.TimeLoopOverlay;
import wwclient.utils.TimeSeriesLayer;
import wwclient.utils.XMLParser;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.swt.widgets.Combo;

public class AddXMLDataView extends ViewPart {

	private FormToolkit formToolkit;
	private ScrolledForm form;
	private CheckboxTableViewer layers;

	private Label lblLoading;	// shows programstate while parsing
	private Text xmlPath;		// holds the path to the xml file
	private Scale scale;		// scale to navigate between the timeseries layer
	private Label lblSelectLayer;	// shows the selected TimeseriesLayer

	private Button btnAnimate;
	private Combo comboSpeed;
	private boolean animate = false;
	private TimeLoopOverlay overlay;
	private WorldWindAWTViewPart worldview;

	public AddXMLDataView() { }

	@Override
	public void createPartControl(Composite parent) {

		formToolkit = new FormToolkit(parent.getDisplay());

		form = formToolkit.createScrolledForm(parent);
		TableWrapLayout layout = new TableWrapLayout();
		form.getBody().setLayout(layout);

		/**
		 * 
		 * Section Parsing XML files ---
		 * 
		 */
		Section sctnLoadXmlData = formToolkit.createSection(form.getBody(), Section.TWISTIE | Section.TITLE_BAR | Section.EXPANDED);
		sctnLoadXmlData.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP, 1, 1));
		formToolkit.paintBordersFor(sctnLoadXmlData);
		sctnLoadXmlData.setText("Load XML Data");

		Composite compositeXML = formToolkit.createComposite(sctnLoadXmlData, SWT.NONE);
		formToolkit.adapt(compositeXML);
		sctnLoadXmlData.setClient(compositeXML);
		compositeXML.setLayout(new GridLayout(1, false));
		// Textinput for file path
		xmlPath = formToolkit.createText(compositeXML, "/Volumes/Macintosh HD/Users/bastian/Desktop/wfs/wfs1.xml", SWT.CENTER);
		xmlPath.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		// Button to start parsing xml file
		Button btnXML = formToolkit.createButton(compositeXML, "Parse XML File", SWT.CENTER);
		btnXML.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false, 1, 1));
		// Label shows loading status
		lblLoading = formToolkit.createLabel(compositeXML, "... ... ...", SWT.CENTER);
		lblLoading.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		btnXML.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblLoading.setText("loading ...");
				//System.out.println("Number of layers: "+layers.getTable().getItems().length);
				WorldWindAWTViewPart view = (WorldWindAWTViewPart) Activator.getView(getViewSite().getWorkbenchWindow(), WorldWindAWTViewPart.ID);
				TimeSeriesLayer layer = null;
				try {
					layer = XMLParser.getXMLData(xmlPath.getText(), view);
				} catch (Exception e1) {
					System.out.println(xmlPath.getText()+": "+e1.toString());
				}
				// add new generated layer to our layerstable
				if(layer != null) {
					addLayerToTable(layer);
				}
				lblLoading.setText("Done!");
			}
		});

		/**
		 * 
		 *  Section --- Layer Manager ---
		 *  
		 */
		Section sctnLayer = formToolkit.createSection(form.getBody(), Section.TWISTIE | Section.TITLE_BAR | Section.EXPANDED);
		sctnLayer.setLayoutData(new TableWrapData(TableWrapData.FILL, TableWrapData.TOP, 1, 1));
		formToolkit.paintBordersFor(sctnLayer);
		sctnLayer.setText("Timeseries Layer");

		Composite compositeLayers = formToolkit.createComposite(sctnLayer);
		TableWrapLayout layoutLayers = new TableWrapLayout();
		layoutLayers.numColumns = 2;
		compositeLayers.setLayout(layoutLayers);
		TableWrapData td = new TableWrapData(TableWrapData.FILL_GRAB);
		td.colspan = 2;
		Table tableLayers = formToolkit.createTable(compositeLayers, SWT.CHECK | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tableLayers.setLayoutData(td);

		sctnLayer.setClient(compositeLayers);

		layers = new CheckboxTableViewer(tableLayers);
		// wird ausgeführt wenn ein Layer ausgewählt wird
		layers.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				// Enable/disable globe layer based on the check status of the table
				TimeSeriesLayer layer = (TimeSeriesLayer) event.getElement();
				layer.setEnabled(event.getChecked());
				// repaint globe
				//				WorldViewPart view = (WorldViewPart) Activator.getView(getViewSite().getWorkbenchWindow(), WorldViewPart.ID);
				worldview.repaint();
			}
		});
		layers.setComparator(new ViewerComparator());

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

		lblSelectLayer = formToolkit.createLabel(compositeControls, "Selected Layer:", SWT.NONE);
		lblSelectLayer.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		new Label(compositeControls, SWT.NONE);

		//		new Label(compositeControls, SWT.NONE);

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
		btnDown.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				downButtonClicked();
			}
			public void widgetDefaultSelected(SelectionEvent event) {
				downButtonClicked();
			}
		});
		new Label(compositeControls, SWT.NONE);

		/**
		 * Animation Section
		 */
		// Set up the Animation Layer for WorldWind
		worldview = (WorldWindAWTViewPart) Activator.getView(getViewSite().getWorkbenchWindow(), WorldWindAWTViewPart.ID);
		overlay = new TimeLoopOverlay("Animated Layer", worldview.getWorldWindow(), 80);

		Section sctnOptions = formToolkit.createSection(form.getBody(), Section.TWISTIE | Section.TITLE_BAR | Section.EXPANDED);
		sctnOptions.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP, 1, 1));
		sctnOptions.setText("Timeseries Animation");

		Composite compositeOptions = formToolkit.createComposite(sctnOptions, SWT.NONE);
		sctnOptions.setClient(compositeOptions);
		compositeOptions.setLayout(new GridLayout(3, false));

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
				overlay = new TimeLoopOverlay("Animated Layer", worldview.getWorldWindow(), Integer.valueOf(comboSpeed.getItem(comboSpeed.getSelectionIndex())));
				System.out.println(comboSpeed.getItem(comboSpeed.getSelectionIndex()));
			}
		});


		// Button to start the Animation
		btnAnimate = new Button(compositeOptions, SWT.NONE);
		formToolkit.adapt(btnAnimate, true, true);
		btnAnimate.setText("Atart Animation");
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
	 * Shows each TimelineLayer for a specific time (TODO)
	 */
	private void animateTimlineLayers() {
		if(animate) {
			btnAnimate.setText("Stop Animation");
			LayerList layerList = worldview.getLayers();
			for (int j = 0; j < layerList.size(); j++) {
				if (layerList.get(j).getValue("isTimelineLayer") != null) {
					overlay.add((TimeSeriesLayer) layerList.get(j));
				}
			}
			overlay.setEnabled(true);
		} else {
			btnAnimate.setText("Start Animation");
			overlay.stop();
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
		System.out.println("Show layer nr.: "+ realselection+" timelinelayers.size: "+timelineLayers.size());
		if(realselection <= timelineLayers.size()-1 && realselection >= 0) {
			TimeSeriesLayer l = timelineLayers.get(realselection);
			l.setEnabled(true);
			lblSelectLayer.setText("Selected Layer: "+l.getName());
			layers.setChecked(l, true);
			worldview.repaint();
			// when there is no layer to show
		} else {
			lblSelectLayer.setText("Selected Layer: None");
		}

	}

	public CheckboxTableViewer getLayersTable() {
		return layers;
	}

	@Override
	public void setFocus() {

	}
}
