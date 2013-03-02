package org.gvsig.sos.lib.impl.parsers.ows_1_1_0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class TelephoneType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private List<java.lang.String> VoiceList = new ArrayList<java.lang.String>();
  	private List<java.lang.String> FacsimileList = new ArrayList<java.lang.String>();
  	
	public TelephoneType(String tagName) {
		super(tagName);
	}
	
  	public void setVoiceList(List<java.lang.String> value){
  		this.VoiceList = value;
  	}
  	public List<java.lang.String> getVoiceList(){
  		return VoiceList;	
  	}   
  	public void setFacsimileList(List<java.lang.String> value){
  		this.FacsimileList = value;
  	}
  	public List<java.lang.String> getFacsimileList(){
  		return FacsimileList;	
  	}   
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
 			
			
		if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_VOICE)==0){
			try{
			    java.lang.String auxVoice = parser.nextText();
			    getVoiceList().add(auxVoice);
				m_localResult = true;
				}catch(Exception e){
					doLog("Error processing: " + nextTagName, e);
					m_localResult = false;
				}
			}  else 
		    
		    
			 
 			
			
		if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_FACSIMILE)==0){
			try{
			    java.lang.String auxFacsimile = parser.nextText();
			    getFacsimileList().add(auxFacsimile);
				m_localResult = true;
				}catch(Exception e){
					doLog("Error processing: " + nextTagName, e);
					m_localResult = false;
				}
			}  else 
		    
		    
			 
		
		 if (ignoreTags){
        	org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IgnoredTag ignore = new org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IgnoredTag(nextTagName);
        	ignore.fromXML(parser);
        	m_localResult = true;
			}
		
		
		return m_localResult;
	}	
	
		
		

}
		
