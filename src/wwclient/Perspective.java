package wwclient;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		String editorArea = layout.getEditorArea();
		
		 // Top left: 
		 IFolderLayout topLeft = layout.createFolder("topLeft", IPageLayout.LEFT, 0.42f, editorArea);
		 topLeft.addView("wwclient.GeoTifView");
		 topLeft.addView("wwclient.AddXMLDataView");
		 topLeft.addView("wwclient.SOSView");
//		 topLeft.addView("wwclient.WFSView");
		 
		 
		 // Bottom left: Outline view and Property Sheet view
		 IFolderLayout bottomLeft = layout.createFolder("bottomLeft", IPageLayout.BOTTOM, 0.64f, "topLeft");
		 bottomLeft.addView("wwclient.ControlsView");

		 layout.addView("wwclient.WorldWindAWTViewPart", IPageLayout.BOTTOM, 0.66f, editorArea);
//		 layout.addView("wwclient.WorldViewPart", IPageLayout.BOTTOM, 0.66f, editorArea);

	}
}
