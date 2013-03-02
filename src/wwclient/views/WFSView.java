package wwclient.views;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import wwclient.Activator;
import wwclient.utils.WFSParser;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.Section;
import org.geotools.data.DataStore;
import org.eclipse.swt.custom.CCombo;

public class WFSView extends ViewPart {
	public WFSView() {
	}


	private FormToolkit formToolkit;
	private ScrolledForm form;
	private CheckboxTableViewer layers;
	
	private WorldWindAWTViewPart worldview;
	private Section sctnFeatureTypeSection;
	private Composite compositeFeatureSection;
	private Combo comboFeatureTypes;
	private Button btnGetfeatures;
	private Label lblSelectFeature;
	private Section sctnGetcapabilities;
	private Text txtWfsurl;
	

	@Override
	public void createPartControl(Composite parent) {
		formToolkit = new FormToolkit(parent.getDisplay());
		form = formToolkit.createScrolledForm(parent);
		TableWrapLayout layout = new TableWrapLayout();
		form.getBody().setLayout(layout);
		
		worldview = (WorldWindAWTViewPart) Activator.getView(getViewSite().getWorkbenchWindow(), WorldWindAWTViewPart.ID);

		/**
		 * GetCapabilities Section
		 */
		sctnGetcapabilities = formToolkit.createSection(form.getBody(), Section.TWISTIE | Section.TITLE_BAR | Section.EXPANDED);
		sctnGetcapabilities.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP, 1, 1));
		formToolkit.paintBordersFor(sctnGetcapabilities);
		sctnGetcapabilities.setText("GetCapabilities");
		
		Composite compositeWFS = formToolkit.createComposite(sctnGetcapabilities, SWT.NONE);
		sctnGetcapabilities.setClient(compositeWFS);
		compositeWFS.setLayout(new GridLayout(1, false));
		
		txtWfsurl = formToolkit.createText(compositeWFS, "", SWT.LEFT);
		txtWfsurl.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		txtWfsurl.setText("http://www.pegelonline.wsv.de/webservices/gis/aktuell/wfs?service=wfs&version=1.1.0&request=GetCapabilities");

		Button btnGetCap = formToolkit.createButton(compositeWFS, "GetCapabilities", SWT.CENTER);
		btnGetCap.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		btnGetCap.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				loadButtonClicked();
			}
			public void widgetDefaultSelected(SelectionEvent event) {
				loadButtonClicked();
			}
		});
		
		/**
		 * Select FeatureType Section
		 */
		sctnFeatureTypeSection = formToolkit.createSection(form.getBody(), Section.TWISTIE | Section.TITLE_BAR);
		sctnFeatureTypeSection.setLayoutData(new TableWrapData(TableWrapData.FILL, TableWrapData.TOP, 1, 1));
		formToolkit.paintBordersFor(sctnFeatureTypeSection);
		sctnFeatureTypeSection.setText("FeatureType Selection");
		sctnFeatureTypeSection.setExpanded(true); //TODO erst wenn geladen auf expanded setzen
		
		compositeFeatureSection = formToolkit.createComposite(sctnFeatureTypeSection);
		sctnFeatureTypeSection.setClient(compositeFeatureSection);
		compositeFeatureSection.setLayout(new GridLayout(2, false));
		
		lblSelectFeature = formToolkit.createLabel(compositeFeatureSection, "Select FeatureType", SWT.NONE);
		
		comboFeatureTypes = new Combo(compositeFeatureSection, SWT.NONE);
		comboFeatureTypes.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		formToolkit.adapt(comboFeatureTypes);
		
		btnGetfeatures = formToolkit.createButton(compositeFeatureSection, "Request GetFeature", SWT.NONE);
		new Label(compositeFeatureSection, SWT.NONE);
		
		
		/**
		 * 
		 *  Section --- Layer Manager ---
		 *  
		 */
		Section sctnLayer = formToolkit.createSection(form.getBody(), Section.TWISTIE | Section.TITLE_BAR | Section.EXPANDED);
		sctnLayer.setLayoutData(new TableWrapData(TableWrapData.FILL, TableWrapData.TOP, 1, 1));
		formToolkit.paintBordersFor(sctnLayer);
		sctnLayer.setText("WFS Layer");

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
			}
		});


	}

	private void loadButtonClicked() {

		DataStore ds = WFSParser.getWFSData(txtWfsurl.getText(), worldview);
		createWFSFeatures(ds);
	}
	
	private void createWFSFeatures(DataStore ds) {
		String[] featuresTypes = null;
		try {
			featuresTypes = ds.getTypeNames();
			comboFeatureTypes.removeAll();
			for(String featureType : featuresTypes) {
				comboFeatureTypes.add(featureType);
			}
			comboFeatureTypes.select(0);
			comboFeatureTypes.pack();
			compositeFeatureSection.pack();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void setFocus() {
	}
}
