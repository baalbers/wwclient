package org.gvsig.sos.lib.impl.parsers.sml_1_0_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Inner_Element_ClassifierList extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private List<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_classifier> classifierList = new ArrayList<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_classifier>();
  	
	public Inner_Element_ClassifierList(String tagName) {
		super(tagName);
	}
	
  	public void setClassifierList(List<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_classifier> value){
  		this.classifierList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_classifier> getClassifierList(){
  		return classifierList;	
  	}   
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SML_CLASSIFIER)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_classifier auxClassifier = new org.gvsig.sos.lib.impl.parsers.sml_1_0_1.Inner_Element_classifier(org.gvsig.sos.lib.impl.parsers.Constants.SML_CLASSIFIER);
					auxClassifier.fromXML(parser);
					 getClassifierList().add(auxClassifier);
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
		
