package org.gvsig.sos.lib.impl.parsers;

import java.io.IOException;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IgnoredTag;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.NameResolver;
import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLInstanceTag;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;


public class AnyTypeRealization extends XMLInstanceTag{
	
	private String xsiType;
	private java.lang.Object value;

	public AnyTypeRealization(String tagName) {
		super(tagName);
	}
	
	
	

	public java.lang.Object getValue() {
		return value;
	}




	public void setValue(java.lang.Object value) {
		this.value = value;
	}




	
	public String getXsiType() {
		return xsiType;
	}




	public void setXsiType(String xsiType) {
		this.xsiType = xsiType;
	}




	/**
	 * Default implementation of fromXML method. Default behavior is to skip any other tag inside the current one 
	 * without processing them. For each unprocessed tag a message is send to the console. 
	 * @throws IllegalConvertionException 
	 */
	 
	public void fromXML(XmlPullParser parser) throws IOException, XmlPullParserException, IllegalConvertionException{
		int currentTag = 2;
		boolean end = false;
		//boolean namespacesAdded = false;
		
		//print(tagName);
		// Precondition check: Initial tag required to be the current tag type
		
		processAttributes(parser);
		
	    boolean isValue = false;
	    String stringValue = null;
	    
	    try{
	    	stringValue = parser.nextText();
	    	isValue = true;
	    } 
	    catch(XmlPullParserException e){
	    	isValue = false;
	    }
	    
	    
	    if (isValue){
	    	value = stringValue;
	    	return;
	    }
				
		// Read next tag		
		//currentTag = parser.nextTag();
		
		while (!end) 
		{
			switch(currentTag)
			{
			case XmlPullParser.START_TAG:
				String nextTagName = NameResolver.getParserNextTag(parser);
				//print("Processing: " + nextTagName );
				// Unknown tag, print corresponding message	
				if (!processTag(nextTagName,parser, false))
					printUnprocessedTagMessage(nextTagName);
				
				NameResolver.cleanLastNamespaceList();
				break;
			case XmlPullParser.END_TAG:
				// If closing tag finish processing 
				end = processEnd(parser);
					
				break;
			case XmlPullParser.TEXT:                   
				break;
			}
			if (!end){
				// Move to next tag
				currentTag = parser.next();
			}
		}  
	}


	protected void processValue(XmlPullParser parser) throws XmlPullParserException, IOException, IllegalConvertionException{
		 String tmpLocalStringValue = parser.nextText();
		  try{
				 setValue(tmpLocalStringValue);
			}catch(Exception e){
					doLog("Error processing: " + tmpLocalStringValue, e);
		    }
			
		}
	 
	protected boolean processTag(String nextTagName, XmlPullParser parser,
			boolean ignoreTags) throws IOException, XmlPullParserException,
			IllegalConvertionException {
	        boolean m_localResult = false;		
	        if(nextTagName.compareTo(org.gvsig.sos.lib.impl.parsers.Constants.SWE_DATAARRAY) == 0)
	        {
	        	try
	        	{
	        		org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataArrayType dataArray = new org.gvsig.sos.lib.impl.parsers.swe_1_0_1.DataArrayType(nextTagName);
	        		dataArray.fromXML(parser);
	        		value = dataArray;
	        		m_localResult = true;
	        	}catch(Exception e)
	        	{
	        		doLog("Error processing: " + nextTagName, e);
	        		m_localResult = false;
	        	}
	        }else
	        {
	        	if(ignoreTags)
	        	{
	        		IgnoredTag ignore = new IgnoredTag(nextTagName);
	        		ignore.fromXML(parser);
	        		m_localResult = true;
	        	}
	        }
	        	
			
			
			return m_localResult;
		
	}

	 
	protected void processAttributes(XmlPullParser parser) throws IllegalConvertionException{
		super.processAttributes(parser);
	    xsiType = getAttributeValue(parser, Constants.XSI_TYPE);
		
	}

	
	
}
