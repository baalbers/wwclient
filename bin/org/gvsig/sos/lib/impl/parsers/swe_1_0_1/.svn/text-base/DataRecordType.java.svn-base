package org.gvsig.sos.lib.impl.parsers.swe_1_0_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class DataRecordType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private List<org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataComponentPropertyType> fieldList = new ArrayList<org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataComponentPropertyType>();
  	
	public DataRecordType(String tagName) {
		super(tagName);
	}
	
  	public void setFieldList(List<org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataComponentPropertyType> value){
  		this.fieldList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataComponentPropertyType> getFieldList(){
  		return fieldList;	
  	}   
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_FIELD)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataComponentPropertyType auxField = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataComponentPropertyType(org.gvsig.sos.lib.impl.parsers.Constants.SWE_FIELD);
					auxField.fromXML(parser);
					 getFieldList().add(auxField);
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
		
