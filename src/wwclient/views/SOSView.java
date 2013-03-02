package wwclient.views;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import wwclient.utils.SOSParser;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.gvsig.sos.lib.impl.parsers.sos_1_0_0.Element_Capabilities;

public class SOSView extends ViewPart {
	
	private final String sosURL = "http://bdesgraph.brgm.fr/REST/sos";
//	private final String sosURL ="http://ispacesrv002.researchstudio.at/sensors/ubimet_avg/sos";
	
	private FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private ScrolledForm form;
	private Text txtSOSURL;
	private Section sctnServerDetails;
	
	private Element_Capabilities capabilities;
	
	public SOSView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		form = formToolkit.createScrolledForm(parent);
		TableWrapLayout layout = new TableWrapLayout();
		form.getBody().setLayout(layout);
		
		Section sctnNewSection = formToolkit.createSection(form.getBody(), Section.TWISTIE | Section.TITLE_BAR);
		sctnNewSection.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB, TableWrapData.TOP, 1, 1));
		sctnNewSection.setBounds(0, 0, 100, 20);
		formToolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("New Section");
		sctnNewSection.setExpanded(true);
		
		Composite composite = formToolkit.createComposite(sctnNewSection, SWT.NONE);
		formToolkit.paintBordersFor(composite);
		sctnNewSection.setClient(composite);
		composite.setLayout(new TableWrapLayout());
		
		Label lblSosUrl = formToolkit.createLabel(composite, "SOS URL:", SWT.NONE);
		lblSosUrl.setLayoutData(new TableWrapData(TableWrapData.FILL, TableWrapData.TOP, 1, 1));
		
		txtSOSURL = formToolkit.createText(composite, "New Text", SWT.NONE);
		txtSOSURL.setLayoutData(new TableWrapData(TableWrapData.FILL, TableWrapData.TOP, 1, 1));
		txtSOSURL.setText(sosURL);

		
		Button btnConnectSOS = formToolkit.createButton(composite, "Connect (start GetCapabilities request)", SWT.CENTER);
		btnConnectSOS.setLayoutData(new TableWrapData(TableWrapData.CENTER, TableWrapData.TOP, 1, 1));
		// Listen to any click on the button
		btnConnectSOS.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				connectButtonClicked();
			}
			public void widgetDefaultSelected(SelectionEvent event) {
				connectButtonClicked();
			}
		});
		
		
		
		sctnServerDetails = formToolkit.createSection(form.getBody(), Section.TWISTIE | Section.TITLE_BAR);
		sctnServerDetails.setEnabled(false);
		sctnServerDetails.setLayoutData(new TableWrapData(TableWrapData.FILL, TableWrapData.TOP, 1, 1));
		formToolkit.paintBordersFor(sctnServerDetails);
		sctnServerDetails.setText("Server Details");
		
	}
	
	private void connectButtonClicked() {
		startGetCapabilitiesRequest(txtSOSURL.getText());
		sctnServerDetails.setEnabled(true);
		sctnServerDetails.setExpanded(true);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	private void startGetCapabilitiesRequest(String SOSURL) {
		capabilities = SOSParser.parseGetCapabilities(SOSURL);
		createServerDetailsSection(capabilities);
	}
	
	private void createServerDetailsSection(Element_Capabilities capabilities){

		Composite compositeServerDetails = formToolkit.createComposite(sctnServerDetails);
		TableWrapLayout layoutServerDetails = new TableWrapLayout();
		compositeServerDetails.setLayout(layoutServerDetails);
		layoutServerDetails.numColumns = 2;
		TableWrapData td;

		Label aux = formToolkit.createLabel(compositeServerDetails, "Service Type: ");
		td = new TableWrapData(TableWrapData.FILL_GRAB);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, capabilities.getServiceIdentification().getServiceType().getValue());
		td = new TableWrapData(TableWrapData.LEFT);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, "Service Version: ");
		td = new TableWrapData(TableWrapData.FILL_GRAB);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, capabilities.getServiceIdentification().getServiceTypeVersionList().get(0));
		td = new TableWrapData(TableWrapData.LEFT);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, "Title: ");
		td = new TableWrapData(TableWrapData.FILL_GRAB);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, capabilities.getServiceIdentification().getTitleList().get(0).getValue());
		td = new TableWrapData(TableWrapData.LEFT);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, "Abstract: ");
		td = new TableWrapData(TableWrapData.FILL_GRAB);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, capabilities.getServiceIdentification().getAbstractList().get(0).getValue());
		td = new TableWrapData(TableWrapData.LEFT);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, "Keywords: ");
		td = new TableWrapData(TableWrapData.FILL_GRAB);
		aux.setLayoutData(td);
		
		if (!capabilities.getServiceIdentification().getKeywordsList().getKeywordList().isEmpty()) {
			aux = formToolkit.createLabel(compositeServerDetails, capabilities.getServiceIdentification().getKeywordsList().getKeywordList().get(0).getValue());
			td = new TableWrapData(TableWrapData.LEFT);
			aux.setLayoutData(td);
		}

		aux = formToolkit.createLabel(compositeServerDetails, "Access Constraints: ");
		td = new TableWrapData(TableWrapData.FILL_GRAB);
		aux.setLayoutData(td);

		String ac = "";
		for(String c: capabilities.getServiceIdentification().getAccessConstraintsList()){
			ac += c + " ";
		}

		aux = formToolkit.createLabel(compositeServerDetails, ac);
		td = new TableWrapData(TableWrapData.LEFT);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, "Fees: ");
		td = new TableWrapData(TableWrapData.FILL_GRAB);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, capabilities.getServiceIdentification().getFees());
		td = new TableWrapData(TableWrapData.LEFT);
		aux.setLayoutData(td);

		aux = formToolkit.createSeparator(compositeServerDetails, SWT.HORIZONTAL);
		td = new TableWrapData(TableWrapData.FILL_GRAB);
		td.colspan = 2;
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, "Provider Name: ");
		td = new TableWrapData(TableWrapData.FILL_GRAB);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, capabilities.getServiceProvider().getProviderName());
		td = new TableWrapData(TableWrapData.LEFT);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, "Provider Site: ");
		td = new TableWrapData(TableWrapData.FILL_GRAB);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, capabilities.getServiceProvider().getProviderSite().getHref());
		td = new TableWrapData(TableWrapData.LEFT);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, "Contact Name: ");
		td = new TableWrapData(TableWrapData.FILL_GRAB);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, capabilities.getServiceProvider().getServiceContact().getIndividualName());
		td = new TableWrapData(TableWrapData.LEFT);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, "Contact Position: ");
		td = new TableWrapData(TableWrapData.FILL_GRAB);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, capabilities.getServiceProvider().getServiceContact().getPositionName());
		td = new TableWrapData(TableWrapData.LEFT);
		aux.setLayoutData(td);

		if(!capabilities.getServiceProvider().getServiceContact().getContactInfo().getPhone().getVoiceList().isEmpty()) {
			aux = formToolkit.createLabel(compositeServerDetails, "Phone: ");
			td = new TableWrapData(TableWrapData.FILL_GRAB);
			aux.setLayoutData(td);
			aux = formToolkit.createLabel(compositeServerDetails, capabilities.getServiceProvider().getServiceContact().getContactInfo().getPhone().getVoiceList().get(0));
			td = new TableWrapData(TableWrapData.LEFT);
			aux.setLayoutData(td);
		}

		aux = formToolkit.createLabel(compositeServerDetails, "Address: ");
		td = new TableWrapData(TableWrapData.FILL_GRAB);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, capabilities.getServiceProvider().getServiceContact().getContactInfo().getAddress().getDeliveryPointList().get(0));
		td = new TableWrapData(TableWrapData.LEFT);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, "City: ");
		td = new TableWrapData(TableWrapData.FILL_GRAB);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, capabilities.getServiceProvider().getServiceContact().getContactInfo().getAddress().getCity());
		td = new TableWrapData(TableWrapData.LEFT);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, "Administrative Area: ");
		td = new TableWrapData(TableWrapData.FILL_GRAB);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, capabilities.getServiceProvider().getServiceContact().getContactInfo().getAddress().getAdministrativeArea());
		td = new TableWrapData(TableWrapData.LEFT);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, "Postal Code: ");
		td = new TableWrapData(TableWrapData.FILL_GRAB);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, capabilities.getServiceProvider().getServiceContact().getContactInfo().getAddress().getPostalCode());
		td = new TableWrapData(TableWrapData.LEFT);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, "Country: ");
		td = new TableWrapData(TableWrapData.FILL_GRAB);
		aux.setLayoutData(td);

		aux = formToolkit.createLabel(compositeServerDetails, capabilities.getServiceProvider().getServiceContact().getContactInfo().getAddress().getCountry());
		td = new TableWrapData(TableWrapData.LEFT);
		aux.setLayoutData(td);



		if(!capabilities.getServiceProvider().getServiceContact().getContactInfo().getAddress().getElectronicMailAddressList().isEmpty()) {
			aux = formToolkit.createLabel(compositeServerDetails, "E-Mail: ");
			td = new TableWrapData(TableWrapData.FILL_GRAB);
			aux.setLayoutData(td);
			aux = formToolkit.createLabel(compositeServerDetails, capabilities.getServiceProvider().getServiceContact().getContactInfo().getAddress().getElectronicMailAddressList().get(0));
			td = new TableWrapData(TableWrapData.LEFT);
			aux.setLayoutData(td);
		}


		sctnServerDetails.setClient(compositeServerDetails);

	}
}
