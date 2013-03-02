package org.gvsig.sos.lib.impl.parsers.xml;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;


public class Attribute_lang implements org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLSimpleTypeContent {
	//Fields Section

		private java.lang.String languageValue;
		boolean isLanguageValueSet = false;
		private java.lang.String langValue;
		boolean isLangValueSet = false;
  	
	public Attribute_lang(){
	}	
	public Attribute_lang(String union) throws IllegalConvertionException{
		processString(union);
	}
	
	  	public void setLanguageValue(java.lang.String value){
  		this.languageValue = value;
  	}	
  	public java.lang.String getLanguageValue(){
  		return languageValue; 	
  	} 
	public boolean isLanguageValueSet(){
  		return isLanguageValueSet;
  	} 	
	  	public void setLangValue(java.lang.String value){
  		this.langValue = value;
  	}	
  	public java.lang.String getLangValue(){
  		return langValue; 	
  	} 
	public boolean isLangValueSet(){
  		return isLangValueSet;
  	} 	
   public void processString(String content) throws IllegalConvertionException{
	   	boolean convertSuccess = false;		 		
		if (!convertSuccess){
			try{
				languageValue = content;
				convertSuccess = true;
				isLanguageValueSet = true;
			}
			catch(Exception e){
				convertSuccess = false;
			}
		}
		if (!convertSuccess){
			try{
				langValue = content;
				convertSuccess = true;
				isLangValueSet = true;
			}
			catch(Exception e){
				convertSuccess = false;
			}
		}
		
		if (!convertSuccess)
			throw new IllegalConvertionException();
	}	
	
}
		
