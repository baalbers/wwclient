package org.gvsig.sos.lib.impl.parsers.gml_3_1_1;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;


public class Inner_Attribute_direction implements org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLSimpleTypeContent {
	//Fields Section

		private java.lang.String directionValue;
		boolean isDirectionValueSet = false;
		private java.lang.String directionValue_1;
		boolean isDirectionValue_1Set = false;
  	
	public Inner_Attribute_direction(){
	}	
	public Inner_Attribute_direction(String union) throws IllegalConvertionException{
		processString(union);
	}
	
	  	public void setDirectionValue(java.lang.String value){
  		this.directionValue = value;
  	}	
  	public java.lang.String getDirectionValue(){
  		return directionValue; 	
  	} 
	public boolean isDirectionValueSet(){
  		return isDirectionValueSet;
  	} 	
	  	public void setDirectionValue_1(java.lang.String value){
  		this.directionValue_1 = value;
  	}	
  	public java.lang.String getDirectionValue_1(){
  		return directionValue_1; 	
  	} 
	public boolean isDirectionValue_1Set(){
  		return isDirectionValue_1Set;
  	} 	
   public void processString(String content) throws IllegalConvertionException{
	   	boolean convertSuccess = false;		 		
		if (!convertSuccess){
			try{
				directionValue = content;
				convertSuccess = true;
				isDirectionValueSet = true;
			}
			catch(Exception e){
				convertSuccess = false;
			}
		}
		if (!convertSuccess){
			try{
				directionValue_1 = content;
				convertSuccess = true;
				isDirectionValue_1Set = true;
			}
			catch(Exception e){
				convertSuccess = false;
			}
		}
		
		if (!convertSuccess)
			throw new IllegalConvertionException();
	}	
	
}
		
