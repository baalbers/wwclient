package org.gvsig.sos.lib.impl.parsers.gml_3_1_1;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;


public class stringOrNull implements org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLSimpleTypeContent {
	//Fields Section

		private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.NullEnumeration NullEnumerationValue;
		boolean isNullEnumerationValueSet = false;
		private java.lang.String stringValue;
		boolean isStringValueSet = false;
		private java.lang.String anyURIValue;
		boolean isAnyURIValueSet = false;
  	
	public stringOrNull(){
	}	
	public stringOrNull(String union) throws IllegalConvertionException{
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
	  	public void setStringValue(java.lang.String value){
  		this.stringValue = value;
  	}	
  	public java.lang.String getStringValue(){
  		return stringValue; 	
  	} 
	public boolean isStringValueSet(){
  		return isStringValueSet;
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
				stringValue = content;
				convertSuccess = true;
				isStringValueSet = true;
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
		
