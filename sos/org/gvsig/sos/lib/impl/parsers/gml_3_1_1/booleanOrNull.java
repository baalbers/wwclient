package org.gvsig.sos.lib.impl.parsers.gml_3_1_1;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;


public class booleanOrNull implements org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLSimpleTypeContent {
	//Fields Section

		private org.gvsig.sos.lib.impl.parsers.gml_3_1_1.NullEnumeration NullEnumerationValue;
		boolean isNullEnumerationValueSet = false;
		private boolean booleanValue;
		boolean isBooleanValueSet = false;
		private java.lang.String anyURIValue;
		boolean isAnyURIValueSet = false;
  	
	public booleanOrNull(){
	}	
	public booleanOrNull(String union) throws IllegalConvertionException{
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
	  	public void setBooleanValue(boolean value){
  		this.booleanValue = value;
  	}	
  	public boolean getBooleanValue(){
  		return booleanValue; 	
  	} 
	public boolean isBooleanValueSet(){
  		return isBooleanValueSet;
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
				  //kept empty as it is a trial. The code added is just to avoid some 
				  //tools to mark an empty catch block here 
					convertSuccess = false;
				}
			}
			if (!convertSuccess){
				try{
					booleanValue = org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.Utilities.
					             convertToBoolean(content);
					convertSuccess = true;
					isBooleanValueSet = true;
				}
				catch(Exception e){
					  //kept empty as it is a trial. The code added is just to avoid some 
					  //tools to mark an empty catch block here 
					convertSuccess = false;
				}
			}
			if (!convertSuccess){
					anyURIValue = content;
					convertSuccess = true;
					isAnyURIValueSet = true;
			}
		
		if (!convertSuccess)
			throw new IllegalConvertionException();
	}	
	
}
		
