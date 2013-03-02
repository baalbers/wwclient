package org.gvsig.sos.lib.impl.parsers.ows_1_1_0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.NameResolver;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;




public class KeywordsType extends org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag {
	//Fields Section
	
	
  	private List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.LanguageStringType> KeywordList = new ArrayList<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.LanguageStringType>();
  	private org.gvsig.sos.lib.impl.parsers.ows_1_1_0.CodeType Type;
  	
	public KeywordsType(String tagName) {
		super(tagName);
	}
	
  	public void setKeywordList(List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.LanguageStringType> value){
  		this.KeywordList = value;
  	}
  	public List<org.gvsig.sos.lib.impl.parsers.ows_1_1_0.LanguageStringType> getKeywordList(){
  		return KeywordList;	
  	}   
  	public void setType(org.gvsig.sos.lib.impl.parsers.ows_1_1_0.CodeType value){
  		this.Type = value;
  	}
  	public org.gvsig.sos.lib.impl.parsers.ows_1_1_0.CodeType getType(){
  		return Type; 	
  	} 
  	
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
	    if (nextTagName.toLowerCase().compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_KEYWORD.toLowerCase())==0){
					try{
					org.gvsig.sos.lib.impl.parsers.ows_1_1_0.LanguageStringType auxKeyword = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.LanguageStringType(org.gvsig.sos.lib.impl.parsers.Constants.OWS_KEYWORD);
					auxKeyword.fromXML(parser);
					 getKeywordList().add(auxKeyword);
						m_localResult = true;
					}catch(Exception e){
						doLog("Error processing: " + nextTagName, e);
						m_localResult = false;
					}
				} else
		    
			 
		     
			    if (nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.OWS_TYPE)==0){
					try{
						Type = new org.gvsig.sos.lib.impl.parsers.ows_1_1_0.CodeType(nextTagName);
						Type.fromXML(parser);
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

	 
	protected boolean processEnd(XmlPullParser parser) {
		String name = NameResolver.getFullName(parser.getName());
		return (name.toLowerCase().compareTo(tagName.toLowerCase()) == 0);
	}	
	
	
	
		
		

}
		
