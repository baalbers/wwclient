package org.gvsig.sos.lib.impl.parsers.sml_1_0_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Element_components extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_ComponentList ComponentList;
  	
	public Element_components(String tagName) {
		super(tagName);
	}
	
  	public void setComponentList(org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_ComponentList value){
  		this.ComponentList = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_ComponentList getComponentList(){
  		return ComponentList; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SML_COMPONENTLIST)==0){
					try{
						ComponentList = new org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_ComponentList(nextTagName);
						ComponentList.fromXML(parser);
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
		
