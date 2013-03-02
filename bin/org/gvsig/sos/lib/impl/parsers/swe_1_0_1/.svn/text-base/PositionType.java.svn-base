package org.gvsig.sos.lib.impl.parsers.swe_1_0_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class PositionType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.VectorPropertyType location;
  	private String referenceFrame;
  	
	public PositionType(String tagName) {
		super(tagName);
	}
	
  	public void setLocation(org.gvsig.sos.lib.impl.parsers.swe_1_0_1.VectorPropertyType value){
  		this.location = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.swe_1_0_1.VectorPropertyType getLocation(){
  		return location; 	
  	}
  	
  	
	public String getReferenceFrame() {
		return referenceFrame;
	}

	public void setReferenceFrame(String referenceFrame) {
		this.referenceFrame = referenceFrame;
	}

	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_LOCATION)==0){
					try{
						location = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.VectorPropertyType(nextTagName);
						location.fromXML(parser);
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

	 
	protected void processAttributes(XmlPullParser parser)
			throws IllegalConvertionException {
		super.processAttributes(parser);
		referenceFrame = getAttributeValue(parser, "referenceFrame");
	}	
	
		
		

}
		
