package org.gvsig.sos.lib.impl.parsers.sml_1_0_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Inner_Element_ComponentList extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private List<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_component> componentList = new ArrayList<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_component>();
  	
	public Inner_Element_ComponentList(String tagName) {
		super(tagName);
	}
	
  	public void setComponentList(List<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_component> value){
  		this.componentList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_component> getComponentList(){
  		return componentList;	
  	}   
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SML_COMPONENT_1)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_component auxComponent = new org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_component(org.gvsig.sos.lib.impl.parsers.Constants.SML_COMPONENT_1);
					auxComponent.fromXML(parser);
					 getComponentList().add(auxComponent);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else
		    
			 
		
		 if (ignoreTags){
        	org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IgnoredTag ignore = new org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IgnoredTag(nextTagName);
        	ignore.fromXML(parser);
        	m_localResult = true;
			}
		
		
		return m_localResult;
	}	
	
		
		

}
		
