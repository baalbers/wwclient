package org.gvsig.sos.lib.impl.parsers.swe_1_0_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IgnoredTag;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class DataComponentPropertyType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	   	private java.lang.String name;
	
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Quantity Quantity;
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Time Time;
  	private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Text text;
  	private XMLInstanceTag AbstractDataRecord;
  	
	public DataComponentPropertyType(String tagName) {
		super(tagName);
	}
  	public void setName(java.lang.String value){
  		this.name = value;
  	}
  	public java.lang.String getName(){
  		return name; 	
  	} 
	
  	public void setQuantity(org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Quantity value){
  		this.Quantity = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Quantity getQuantity(){
  		return Quantity; 	
  	} 
  	public void setTime(org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Time value){
  		this.Time = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Time getTime(){
  		return Time; 	
  	} 
  	public void setAbstractDataRecord(XMLInstanceTag value){
  		this.AbstractDataRecord = value;
  	}
  	public XMLInstanceTag getAbstractDataRecord(){
  		return AbstractDataRecord; 	
  	} 
	public org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Text getText() {
		return text;
	}
	public void setText(org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Text text) {
		this.text = text;
	}
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_QUANTITY)==0){
					try{
						Quantity = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Quantity(nextTagName);
						Quantity.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
					if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_TEXT)==0){
						try{
							text = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Text(nextTagName);
							text.fromXML(parser);
							m_localResult = true;
						}catch(Exception e){
							doLog("Error processing: " + nextTagName, e);
							m_localResult = false;
						}
					} else 	
		
		
			  
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_TIME)==0){
					try{
						Time = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Element_Time(nextTagName);
						Time.fromXML(parser);
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
					
		
							//TAGS TO IGNORED
							if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_ENVELOPE)==0){
								try{
									IgnoredTag tag = new IgnoredTag(nextTagName);
									tag.fromXML(parser);
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
			    name = getAttributeValue(parser, org.gvsig.sos.lib.impl.parsers.Constants.SWE_NAME_1);
		
	}

}
		
