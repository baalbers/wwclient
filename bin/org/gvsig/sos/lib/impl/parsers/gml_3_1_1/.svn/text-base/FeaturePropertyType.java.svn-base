package org.gvsig.sos.lib.impl.parsers.gml_3_1_1;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class FeaturePropertyType extends XMLInstanceTag {
	//Fields Section
	
	   	private java.lang.String href;
	
  	private XMLInstanceTag _Feature;
  	
	public FeaturePropertyType(String tagName) {
		super(tagName);
	}
  	public void setHref(java.lang.String value){
  		this.href = value;
  	}
  	public java.lang.String getHref(){
  		return href; 	
  	} 
	
  	public void set_Feature(XMLInstanceTag value){
  		this._Feature = value;
  	}
  	public XMLInstanceTag get_Feature(){
  		return _Feature; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML__FEATURE)==0){
					try{
						_Feature = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.FeatureCollectionType(nextTagName);
						_Feature.fromXML(parser);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else 
				
							if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_FEATURECOLLECTION)==0){
							try{
								_Feature = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.FeatureCollectionType(nextTagName);
								_Feature.fromXML(parser);
								m_localResult = true;
							}catch(Exception e){
								doLog("Error processing: " + nextTagName, e);
								m_localResult = false;
							}
						} else if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SMP_SAMPLINGPOINT)==0){
							try{
								_Feature = new org.gvsig.sos.lib.impl.parsers.sampling_1_0_0.SamplingPointType(nextTagName);
								_Feature.fromXML(parser);
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
		
