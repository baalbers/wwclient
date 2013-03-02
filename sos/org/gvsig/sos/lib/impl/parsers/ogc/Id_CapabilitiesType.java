package org.gvsig.sos.lib.impl.parsers.ogc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Id_CapabilitiesType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private List<org.gvsig.sos.lib.impl.parsers.ogc.Element_EID> EIDList = new ArrayList<org.gvsig.sos.lib.impl.parsers.ogc.Element_EID>();
  	private List<org.gvsig.sos.lib.impl.parsers.ogc.Element_FID> FIDList = new ArrayList<org.gvsig.sos.lib.impl.parsers.ogc.Element_FID>();
  	
	public Id_CapabilitiesType(String tagName) {
		super(tagName);
	}
	
  	public void setEIDList(List<org.gvsig.sos.lib.impl.parsers.ogc.Element_EID> value){
  		this.EIDList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.ogc.Element_EID> getEIDList(){
  		return EIDList;	
  	}   
  	public void setFIDList(List<org.gvsig.sos.lib.impl.parsers.ogc.Element_FID> value){
  		this.FIDList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.ogc.Element_FID> getFIDList(){
  		return FIDList;	
  	}   
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OGC_EID)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.ogc.Element_EID auxEID = new org.gvsig.sos.lib.impl.parsers.ogc.Element_EID(org.gvsig.sos.lib.impl.parsers.Constants.OGC_EID);
					auxEID.fromXML(parser);
					 getEIDList().add(auxEID);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else
		    
			 
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OGC_FID)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.ogc.Element_FID auxFID = new org.gvsig.sos.lib.impl.parsers.ogc.Element_FID(org.gvsig.sos.lib.impl.parsers.Constants.OGC_FID);
					auxFID.fromXML(parser);
					 getFIDList().add(auxFID);
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
		
