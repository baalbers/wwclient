package org.gvsig.sos.lib.impl.parsers.gml_3_1_1;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;


public class integerOrNull implements org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLSimpleTypeContent {
	//Fields Section

		private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.NullEnumeration NullEnumerationValue;
		boolean isNullEnumerationValueSet = false;
		private Integer integerValue;
		boolean isIntegerValueSet = false;
		private java.lang.String anyURIValue;
		boolean isAnyURIValueSet = false;
  	
	public integerOrNull(){
	}	
	public integerOrNull(String union) throws IllegalConvertionException{
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
	  	public void setIntegerValue(Integer value){
  		this.integerValue = value;
  	}	
  	public Integer getIntegerValue(){
  		return integerValue; 	
  	} 
	public boolean isIntegerValueSet(){
  		return isIntegerValueSet;
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
				integerValue = org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.Utilities.
				             convertToInteger(content);
				convertSuccess = true;
				isIntegerValueSet = true;
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
		
