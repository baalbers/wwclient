package org.gvsig.sos.lib.impl.parsers.sos_1_0_0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Inner_Element_ObservationOfferingList extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private List<org.gvsig.sos.lib.impl.parsers.sos_1_0_0.ObservationOfferingType> ObservationOfferingList = new ArrayList<org.gvsig.sos.lib.impl.parsers.sos_1_0_0.ObservationOfferingType>();
  	
	public Inner_Element_ObservationOfferingList(String tagName) {
		super(tagName);
	}
	
  	public void setObservationOfferingList(List<org.gvsig.sos.lib.impl.parsers.sos_1_0_0.ObservationOfferingType> value){
  		this.ObservationOfferingList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.sos_1_0_0.ObservationOfferingType> getObservationOfferingList(){
  		return ObservationOfferingList;	
  	}   
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SOS_OBSERVATIONOFFERING) == 0){
					try{
					org.gvsig.sos.lib.impl.parsers.sos_1_0_0.ObservationOfferingType auxObservationOffering = new org.gvsig.sos.lib.impl.parsers.sos_1_0_0.ObservationOfferingType(org.gvsig.sos.lib.impl.parsers.Constants.SOS_OBSERVATIONOFFERING);
					auxObservationOffering.fromXML(parser);
					 getObservationOfferingList().add(auxObservationOffering);
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
		
