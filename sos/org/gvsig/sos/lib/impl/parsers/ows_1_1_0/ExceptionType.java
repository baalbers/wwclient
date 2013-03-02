package org.gvsig.sos.lib.impl.parsers.ows_1_1_0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.gvsig.sos.lib.impl.parsers.Constants;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IgnoredTag;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;


/**
 * <p> This class represents information returned by a server in its capabilities 
 * document </p>
 * 
 * @author Alain Tamayo Fong (alain_tamayo@yahoo.com)
 */
public class ExceptionType extends XMLInstanceTag {

	//Fields Section
	
  	private java.lang.String exceptionCode;
  	private java.lang.String locator;
	
  	private List<java.lang.String> ExceptionText = new ArrayList<java.lang.String>();
  	
  	
	/**
	 * Class constructor
	 */
	public ExceptionType(String tagName) {
		super(tagName);
	}

  	public void setExceptionCode(java.lang.String value){
  		this.exceptionCode = value;
  	}
  	public java.lang.String getExceptionCode(){
  		return exceptionCode; 	
  	} 
  	public void setLocator(java.lang.String value){
  		this.locator = value;
  	}
  	public java.lang.String getLocator(){
  		return locator; 	
  	} 
	
  	public void setExceptionText(List<java.lang.String> value){
  		this.ExceptionText = value;
  	}
  		
  	public List<java.lang.String> getExceptionText(){
  		return ExceptionText;	
  	}   
  	
	@Override
	protected boolean processTag(String nextTagName, XmlPullParser parser, boolean ignoreTags) throws IOException, XmlPullParserException, IllegalConvertionException {
		boolean m_localResult = false;
		
				
	
 		if (nextTagName.compareTo(Constants.OWS_EXCEPTIONTEXT_11)==0  || nextTagName.compareTo(Constants.OWS_EXCEPTIONTEXT)==0){
			try{
			    java.lang.String auxExceptionText = parser.nextText();
			    getExceptionText().add(auxExceptionText);
			 
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
			    exceptionCode = getAttributeValue(parser, Constants.OWS_EXCEPTIONCODE);
		
			    locator = getAttributeValue(parser, Constants.OWS_LOCATOR);
		
	}

}
		
