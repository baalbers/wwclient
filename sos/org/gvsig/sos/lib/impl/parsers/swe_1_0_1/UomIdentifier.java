package org.gvsig.sos.lib.impl.parsers.swe_1_0_1;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;


public class UomIdentifier implements org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLSimpleTypeContent {
	//Fields Section

		private java.lang.String UomSymbolValue;
		boolean isUomSymbolValueSet = false;
		private java.lang.String UomURIValue;
		boolean isUomURIValueSet = false;
  	
	public UomIdentifier(){
	}	
	public UomIdentifier(String union) throws IllegalConvertionException{
		processString(union);
	}
	
	  	public void setUomSymbolValue(java.lang.String value){
  		this.UomSymbolValue = value;
  	}	
  	public java.lang.String getUomSymbolValue(){
  		return UomSymbolValue; 	
  	} 
	public boolean isUomSymbolValueSet(){
  		return isUomSymbolValueSet;
  	} 	
	  	public void setUomURIValue(java.lang.String value){
  		this.UomURIValue = value;
  	}	
  	public java.lang.String getUomURIValue(){
  		return UomURIValue; 	
  	} 
	public boolean isUomURIValueSet(){
  		return isUomURIValueSet;
  	} 	
   public void processString(String content) throws IllegalConvertionException{
	   	boolean convertSuccess = false;		 		
		if (!convertSuccess){
			try{
				UomSymbolValue = content;
				convertSuccess = true;
				isUomSymbolValueSet = true;
			}
			catch(Exception e){
			  convertSuccess = false;
			}
		}
		if (!convertSuccess){
			try{
				UomURIValue = content;
				convertSuccess = true;
				isUomURIValueSet = true;
			}
			catch(Exception e){
				convertSuccess = false;
			}
		}
		
		if (!convertSuccess)
			throw new IllegalConvertionException();
	}	
	
}
		
