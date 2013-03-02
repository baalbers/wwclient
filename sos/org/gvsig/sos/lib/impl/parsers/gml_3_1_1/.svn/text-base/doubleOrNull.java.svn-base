package org.gvsig.sos.lib.impl.parsers.gml_3_1_1;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;


public class doubleOrNull implements org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLSimpleTypeContent {
	//Fields Section

		private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.NullEnumeration NullEnumerationValue;
		boolean isNullEnumerationValueSet = false;
		private Double doubleValue;
		boolean isDoubleValueSet = false;
		private java.lang.String anyURIValue;
		boolean isAnyURIValueSet = false;
  	
	public doubleOrNull(){
	}	
	
	public doubleOrNull(String union) throws IllegalConvertionException{
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
	  	public void setDoubleValue(Double value){
  		this.doubleValue = value;
  	}	
  	public Double getDoubleValue(){
  		return doubleValue; 	
  	} 
	public boolean isDoubleValueSet(){
  		return isDoubleValueSet;
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
				doubleValue = org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.Utilities.
				             convertToDouble(content);
				convertSuccess = true;
				isDoubleValueSet = true;
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
		
