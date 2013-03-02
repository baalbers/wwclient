package org.gvsig.sos.lib.impl.parsers.sos_1_0_0;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Element_Contents extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private org.gvsig.sos.lib.impl.parsers.sos_1_0_0.Inner_Element_ObservationOfferingList ObservationOfferingList;
  	
	public Element_Contents(String tagName) {
		super(tagName);
	}
	
  	public void setObservationOfferingList(org.gvsig.sos.lib.impl.parsers.sos_1_0_0.Inner_Element_ObservationOfferingList value){
  		this.ObservationOfferingList = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.sos_1_0_0.Inner_Element_ObservationOfferingList getObservationOfferingList(){
  		return ObservationOfferingList; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SOS_OBSERVATIONOFFERINGLIST)==0){
					try{
						ObservationOfferingList = new org.gvsig.sos.lib.impl.parsers.sos_1_0_0.Inner_Element_ObservationOfferingList(nextTagName);
						ObservationOfferingList.fromXML(parser);
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
		
