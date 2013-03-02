package org.gvsig.sos.lib.impl.parsers.ogc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class ComparisonOperatorsType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private List<java.lang.String> ComparisonOperatorList = new ArrayList<java.lang.String>();
  	
	public ComparisonOperatorsType(String tagName) {
		super(tagName);
	}
	
  	public void setComparisonOperatorList(List<java.lang.String> value){
  		this.ComparisonOperatorList = value;
  	}
  	public List<java.lang.String> getComparisonOperatorList(){
  		return ComparisonOperatorList;	
  	}   
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
 			
			
		if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OGC_COMPARISONOPERATOR)==0){
			try{
			    java.lang.String auxComparisonOperator = parser.nextText();
			    getComparisonOperatorList().add(auxComparisonOperator);
				m_localResult = true;
				}catch(Exception e){
					doLog("Error processing: " + nextTagName, e);
					m_localResult = false;
				}
			}  else 
		    
		    
			 
		
		 if (ignoreTags){
        	org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IgnoredTag ignore = new org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IgnoredTag(nextTagName);
        	ignore.fromXML(parser);
        	m_localResult = true;
			}
		
		
		return m_localResult;
	}	
	
		
		

}
		
