package org.gvsig.sos.lib.impl.parsers.gml_3_1_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class FeatureCollectionType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private List<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.FeaturePropertyType> featureMemberList = new ArrayList<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.FeaturePropertyType>();
  	
	public FeatureCollectionType(String tagName) {
		super(tagName);
	}
	
  	public void setFeatureMemberList(List<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.FeaturePropertyType> value){
  		this.featureMemberList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.gml_3_1_1.FeaturePropertyType> getFeatureMemberList(){
  		return featureMemberList;	
  	}   
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.GML_FEATUREMEMBER)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.gml_3_1_1.FeaturePropertyType auxFeatureMember = new org.gvsig.sos.lib.impl.parsers.gml_3_1_1.FeaturePropertyType(org.gvsig.sos.lib.impl.parsers.Constants.GML_FEATUREMEMBER);
					auxFeatureMember.fromXML(parser);
					 getFeatureMemberList().add(auxFeatureMember);
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
		
