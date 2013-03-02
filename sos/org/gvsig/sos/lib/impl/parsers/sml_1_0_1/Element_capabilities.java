package org.gvsig.sos.lib.impl.parsers.sml_1_0_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Element_capabilities extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private XMLInstanceTag AbstractDataRecord;
  	
	public Element_capabilities(String tagName) {
		super(tagName);
	}
	
  	public void setAbstractDataRecord(XMLInstanceTag value){
  		this.AbstractDataRecord = value;
  	}
  	public XMLInstanceTag getAbstractDataRecord(){
  		return AbstractDataRecord; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_ABSTRACTDATARECORD)==0){
					try{
						AbstractDataRecord = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.SimpleDataRecordType(nextTagName);
						AbstractDataRecord.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
							if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_SIMPLEDATARECORD)==0){
							try{
								AbstractDataRecord = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.SimpleDataRecordType(nextTagName);
								AbstractDataRecord.fromXML(parser);
								m_localResult = true;
							}catch(Exception e){
								doLog("Error processing: " + nextTagName, e);
								m_localResult = false;
							}
						} else 
					
							if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_DATARECORD)==0){
								try{
									AbstractDataRecord = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataRecordType(nextTagName);
									AbstractDataRecord.fromXML(parser);
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
		
