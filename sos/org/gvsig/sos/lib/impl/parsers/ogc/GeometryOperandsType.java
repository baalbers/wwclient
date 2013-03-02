package org.gvsig.sos.lib.impl.parsers.ogc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class GeometryOperandsType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private List<java.lang.String> GeometryOperandList = new ArrayList<java.lang.String>();
  	
	public GeometryOperandsType(String tagName) {
		super(tagName);
	}
	
  	public void setGeometryOperandList(List<java.lang.String> value){
  		this.GeometryOperandList = value;
  	}
  	public List<java.lang.String> getGeometryOperandList(){
  		return GeometryOperandList;	
  	}   
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
 			
			
		if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OGC_GEOMETRYOPERAND)==0){
			try{
			    java.lang.String auxGeometryOperand = parser.nextText();
			    getGeometryOperandList().add(auxGeometryOperand);
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
		
