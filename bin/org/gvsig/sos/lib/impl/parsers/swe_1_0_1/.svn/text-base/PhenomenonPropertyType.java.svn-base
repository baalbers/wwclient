package org.gvsig.sos.lib.impl.parsers.swe_1_0_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class PhenomenonPropertyType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	   	private java.lang.String href;
	
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.CompositePhenomenonType Phenomenon;
  	
	public PhenomenonPropertyType(String tagName) {
		super(tagName);
	}
  	public void setHref(java.lang.String value){
  		this.href = value;
  	}
  	public java.lang.String getHref(){
  		return href; 	
  	} 
	
  	public void setPhenomenon(org.gvsig.sos.lib.impl.parsers.swe_1_0_1.CompositePhenomenonType value){
  		this.Phenomenon = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.swe_1_0_1.CompositePhenomenonType getPhenomenon(){
  		return Phenomenon; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_PHENOMENON)==0){
					try{
						Phenomenon = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.CompositePhenomenonType(nextTagName);
						Phenomenon.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
							if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_COMPOSITEPHENOMENON)==0){
							try{
								Phenomenon = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.CompositePhenomenonType(nextTagName);
								Phenomenon.fromXML(parser);
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
	
		
		
	 
	protected void processAttributes(XmlPullParser parser) throws IllegalConvertionException{
		 super.processAttributes(parser); 
			    href = getAttributeValue(parser, org.gvsig.sos.lib.impl.parsers.Constants.XLINK_HREF);
		
	}

}
		
