package org.gvsig.sos.lib.impl.parsers.ows_1_1_0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class Element_HTTP extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.RequestMethodType> GetList = new ArrayList<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.RequestMethodType>();
  	private List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.RequestMethodType> PostList = new ArrayList<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.RequestMethodType>();
  	
	public Element_HTTP(String tagName) {
		super(tagName);
	}
	
  	public void setGetList(List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.RequestMethodType> value){
  		this.GetList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.RequestMethodType> getGetList(){
  		return GetList;	
  	}   
  	public void setPostList(List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.RequestMethodType> value){
  		this.PostList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.RequestMethodType> getPostList(){
  		return PostList;	
  	}   
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
		
				
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_GET)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.ows_1_1_0.RequestMethodType auxGet = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.RequestMethodType(org.gvsig.sos.lib.impl.parsers.Constants.OWS_GET);
					auxGet.fromXML(parser);
					 getGetList().add(auxGet);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else
		    
			 
 			
		    
		    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_POST)==0){
					try{
					org.gvsig.sos.lib.impl.parsers.ows_1_1_0.RequestMethodType auxPost = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.RequestMethodType(org.gvsig.sos.lib.impl.parsers.Constants.OWS_POST);
					auxPost.fromXML(parser);
					 getPostList().add(auxPost);
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
		
