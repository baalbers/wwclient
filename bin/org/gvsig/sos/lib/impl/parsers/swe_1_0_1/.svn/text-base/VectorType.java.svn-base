package org.gvsig.sos.lib.impl.parsers.swe_1_0_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class VectorType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private List<org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Inner_Element_coordinate> coordinateList = new ArrayList<org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Inner_Element_coordinate>();
  	
	public VectorType(String tagName) {
		super(tagName);
	}
	
  	public void setCoordinateList(List<org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Inner_Element_coordinate> value){
  		this.coordinateList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Inner_Element_coordinate> getCoordinateList(){
  		return coordinateList;	
  	}   
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_COORDINATE)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Inner_Element_coordinate auxCoordinate = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.Inner_Element_coordinate(org.gvsig.sos.lib.impl.parsers.Constants.SWE_COORDINATE);
					auxCoordinate.fromXML(parser);
					 getCoordinateList().add(auxCoordinate);
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
		
