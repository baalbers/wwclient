package org.gvsig.sos.lib.impl.parsers.swe_1_0_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class BlockEncodingPropertyType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_TextBlock TextBlock;
  	
	public BlockEncodingPropertyType(String tagName) {
		super(tagName);
	}
	
  	public void setTextBlock(org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_TextBlock value){
  		this.TextBlock = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_TextBlock getTextBlock(){
  		return TextBlock; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_TEXTBLOCK)==0){
					try{
						TextBlock = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_TextBlock(nextTagName);
						TextBlock.fromXML(parser);
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
		
