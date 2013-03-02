package org.gvsig.sos.lib.impl.parsers.gml_3_1_1;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;


public class NameOrNull implements org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLSimpleTypeContent {
	//Fields Section

		private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.NullEnumeration NullEnumerationValue;
		boolean isNullEnumerationValueSet = false;
		private java.lang.String NameValue;
		boolean isNameValueSet = false;
		private java.lang.String anyURIValue;
		boolean isAnyURIValueSet = false;
  	
	public NameOrNull(){
	}	
	public NameOrNull(String union) throws IllegalConvertionException{
		processString(union);
	}
	
	  	public void setNullEnumerationValue(org.gvsig.sos.lib.impl.parsers.gml_3_1_1.NullEnumeration value){
  		this.NullEnumerationValue = value;
  	}	
  	public org.gvsig.sos.lib.impl.parsers.gml_3_1_1.NullEnumeration getNullEnumerationValue(){
  		return NullEnumerationValue; 	
  	} 
	public boolean isNullEnumerationValueSet(){
  		return isNullEnumerationValueSet;
  	} 	
	  	public void setNameValue(java.lang.String value){
  		this.NameValue = value;
  	}	
  	public java.lang.String getNameValue(){
  		return NameValue; 	
  	} 
	public boolean isNameValueSet(){
  		return isNameValueSet;
  	} 	
	  	public void setAnyURIValue(java.lang.String value){
  		this.anyURIValue = value;
  	}	
  	public java.lang.String getAnyURIValue(){
  		return anyURIValue; 	
  	} 
	public boolean isAnyURIValueSet(){
  		return isAnyURIValueSet;
  	} 	
   public void processString(String content) throws IllegalConvertionException{
	   	boolean convertSuccess = false;		 		
		if (!convertSuccess){
			try{
				NullEnumerationValue = new  org.gvsig.sos.lib.impl.parsers.gml_3_1_1.NullEnumeration();
				NullEnumerationValue.processString(content);
				convertSuccess = true;
				isNullEnumerationValueSet = true;
			}
			catch(Exception e){
				convertSuccess = false;
			}
		}
		if (!convertSuccess){
			try{
				NameValue = content;
				convertSuccess = true;
				isNameValueSet = true;
			}
			catch(Exception e){
				convertSuccess = false;
			}
		}
		if (!convertSuccess){
			try{
				anyURIValue = content;
				convertSuccess = true;
				isAnyURIValueSet = true;
			}
			catch(Exception e){
				convertSuccess = false;
			}
		}
		
		if (!convertSuccess)
			throw new IllegalConvertionException();
	}	
	
}
		
