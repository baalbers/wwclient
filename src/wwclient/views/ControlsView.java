package wwclient.views;

import gov.nasa.worldwind.layers.Layer;
import gov.nasa.worldwind.layers.LayerList;

import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.ui.part.ViewPart;

import wwclient.Activator;

public class ControlsView extends ViewPart {
	
	public static final String ID = "wwclient.ControlsView";
	
    // Layers in WorldView
	private FormToolkit toolkit;
	private ScrolledForm form;
	// enthält die Layer
	private CheckboxTableViewer layers;
	
	public ControlsView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		// erstellen des Hauptlayouts der view (Form mit FillLayout)
		toolkit = new FormToolkit(parent.getDisplay());
		form = toolkit.createScrolledForm(parent);
		TableWrapLayout layout = new TableWrapLayout();
//				layout.numColumns = 2;
		form.getBody().setLayout(layout);
		
		// Einteilen der View in Sections
		// --- Zeitreihen Navigation
		
//		Section sctnTimeseriesControl = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.TITLE_BAR | Section.EXPANDED);
//		sctnTimeseriesControl.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP, 1, 1));
//		toolkit.paintBordersFor(sctnTimeseriesControl);
//		sctnTimeseriesControl.setText("Timeseries controls");
//		sctnTimeseriesControl.setExpanded(true);
//		
//		Composite composite = new Composite(sctnTimeseriesControl, SWT.NONE);
//		toolkit.adapt(composite);
//		toolkit.paintBordersFor(composite);
//		sctnTimeseriesControl.setClient(composite);
//		composite.setLayout(new GridLayout(1, false));
//		// Label TODO: should show the timeseries layer which is selected right now
//		Label lblSelectLayer = toolkit.createLabel(composite, "selected Layer:", SWT.NONE);
//		lblSelectLayer.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
//		// Scale (Slider) um einen Zeitreihenlayer auszuwählen
//		Scale scale = new Scale(composite, SWT.NONE);
//		scale.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, false, false, 1, 1));
//		scale.setEnabled(true);	// TODO: sollte nur enabled sein, wenn Zeitreihenlaer geladen wurden!
//		toolkit.adapt(scale, true, true);
		
		// --- Layer Section ---
		Section sctnLayer = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.TITLE_BAR | Section.EXPANDED);
		sctnLayer.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP, 1, 1));
		sctnLayer.setText("Layer in WorldView:");
		Composite compositeLayers = toolkit.createComposite(sctnLayer);
		// Tabelle mit 2 Spalten für Layername und Checkbox
		TableWrapLayout layoutLayers = new TableWrapLayout();
		layoutLayers.numColumns = 2;
		compositeLayers.setLayout(layoutLayers);
		TableWrapData td = new TableWrapData(TableWrapData.FILL_GRAB);
		td.colspan = 2;
		Table tableLayers = toolkit.createTable(compositeLayers, SWT.CHECK | SWT.BORDER| SWT.H_SCROLL | SWT.V_SCROLL);
		tableLayers.setLayoutData(td);
		// Tabelle zu Section hinzufügen
		sctnLayer.setClient(compositeLayers);
		
		layers = new CheckboxTableViewer(tableLayers);

		// wird ausgeführt wenn ein Layer ausgewählt wird
		layers.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				// Enable/disable globe layer based on the check status of the table
				Layer layer = (Layer) event.getElement();
				layer.setEnabled(event.getChecked());
				// repaint globe
				WorldWindAWTViewPart view = (WorldWindAWTViewPart) Activator.getView(getViewSite().getWorkbenchWindow(), WorldWindAWTViewPart.ID);
				view.repaint();
			}
		});
		
		loadLayersToTable();

	}

	public CheckboxTableViewer getLayersTable() {
		return this.layers;
	}

	/**
	 * Loads all Layers from the WorldWind Model to the CheckboxTableViewer "layers"
	 */
	public void loadLayersToTable() {
		WorldWindAWTViewPart view = (WorldWindAWTViewPart) Activator.getView(getViewSite().getWorkbenchWindow(), WorldWindAWTViewPart.ID);
		if (view != null) {
			LayerList list = view.getLayers();
			// clear the table first (so we don't have double entries when this method is called again)
			layers.getTable().clearAll();
			layers.refresh();
			// add all layers
			for (Layer layer : list) {
				layers.add(layer);
				layers.setChecked(layer, layer.isEnabled());
			}
		}
	}
	
	@Override
	public void setFocus() {
	}

}
