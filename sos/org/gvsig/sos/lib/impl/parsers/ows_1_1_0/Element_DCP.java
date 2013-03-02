package org.gvsig.sos.lib.impl.parsers.ows_1_1_0;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Element_DCP extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_HTTP HTTP;
  	
	public Element_DCP(String tagName) {
		super(tagName);
	}
	
  	public void setHTTP(org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_HTTP value){
  		this.HTTP = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_HTTP getHTTP(){
  		return HTTP; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_HTTP)==0){
					try{
						HTTP = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.Element_HTTP(nextTagName);
						HTTP.fromXML(parser);
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
		
