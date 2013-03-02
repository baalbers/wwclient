package org.gvsig.sos.lib.impl.parsers.ows_1_1_0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.Constants;
import org.gvsig.sos.lib.impl.parsers.xml.Attribute_lang;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IgnoredTag;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.NameResolver;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;


/**
 * <p> This class represents information returned by a server in its capabilities 
 * document </p>
 * 
 * @author Alain Tamayo Fong (alain_tamayo@yahoo.com)
 */
public class Element_ExceptionReport extends XMLInstanceTag {

	//Fields Section
	
  	private Attribute_lang lang;
  	private java.lang.String version;
	
  	private List<ExceptionType> Exception = new ArrayList<ExceptionType>();
  	
  	
	/**
	 * Class constructor
	 */
	public Element_ExceptionReport(String tagName) {
		super(tagName);
	}

  	public void setLang(Attribute_lang value){
  		this.lang = value;
  	}
  	public Attribute_lang getLang(){
  		return lang; 	
  	} 
  	public void setVersion(java.lang.String value){
  		this.version = value;
  	}
  	public java.lang.String getVersion(){
  		return version; 	
  	} 
	
  	public void setException(List<ExceptionType> value){
  		this.Exception = value;
  	}
  		
  	public List<ExceptionType> getException(){
  		return Exception;	
  	}   
  	
	@Override
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
				
	
 		if (nextTagName.compareTo(Constants.OWS_EXCEPTION_11)==0 || nextTagName.compareTo(Constants.OWS_EXCEPTION)==0){
			try{
			 ExceptionType auxException = new ExceptionType((nextTagName.compareTo(Constants.OWS_EXCEPTION_11)==0)?Constants.OWS_EXCEPTION_11 : Constants.OWS_EXCEPTION);
			 auxException.fromXML(parser);
			 getException().add(auxException);
			 
		     m_localResult = true;
			}catch(Exception e){
				doLog("Error processing: " + nextTagName, e);
				m_localResult = false;
			}
		}  else  
		
		 if (ignoreTags){
        	IgnoredTag ignore = new IgnoredTag(nextTagName);
        	ignore.fromXML(parser);
        	m_localResult = true;
			}
		
		
		return m_localResult;
	}	
	
		
		
	@Override
	protected void processAttributes(XmlPullParser parser) throws IllegalConvertionException{
		super.processAttributes(parser);
				    java.lang.String auxLang = getAttributeValue(parser, Constants.XML_LANG);		    
				    if (auxLang != null){
						lang = new Attribute_lang();
						lang.processString(auxLang);
				    }
			
		
			    version = getAttributeValue(parser, Constants.OWS_VERSION_1_2);
		
	}

	protected boolean processEnd(XmlPullParser parser) {
		String name = NameResolver.getFullName(parser.getName());
		return (name.compareTo(tagName) == 0);
	}

	
}
		
