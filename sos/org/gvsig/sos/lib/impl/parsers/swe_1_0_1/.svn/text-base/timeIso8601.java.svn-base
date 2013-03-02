package org.gvsig.sos.lib.impl.parsers.swe_1_0_1;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;


public class timeIso8601 implements org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLSimpleTypeContent {
	//Fields Section

		//private DateTime dateValue;
		//boolean isDateValueSet = false;
		//private DateTime timeValue;
		//boolean isTimeValueSet = false;
		private String dateTimeValue;
		boolean isDateTimeValueSet = false;
		private java.lang.String TimeIndeterminateValueTypeValue;
		boolean isTimeIndeterminateValueTypeValueSet = false;
  	
	public timeIso8601(){
	}	
	public timeIso8601(String union) throws IllegalConvertionException{
		processString(union);
	}
	
	/*  	public void setDateValue(DateTime value){
  		this.dateValue = value;
  	}	
  	public DateTime getDateValue(){
  		return dateValue; 	
  	} 
	public boolean isDateValueSet(){
  		return isDateValueSet;
  	} 	
	  	public void setTimeValue(DateTime value){
  		this.timeValue = value;
  	}	
  	public DateTime getTimeValue(){
  		return timeValue; 	
  	} 
	public boolean isTimeValueSet(){
  		return isTimeValueSet;
  	} 	*/
	
	public void setDateTimeValue(String value){
  		this.dateTimeValue = value;
  	}	
  	public String getDateTimeValue(){
  		return dateTimeValue; 	
  	} 
	public boolean isDateTimeValueSet(){
  		return isDateTimeValueSet;
  	} 	
	  	public void setTimeIndeterminateValueTypeValue(java.lang.String value){
  		this.TimeIndeterminateValueTypeValue = value;
  	}	
  	public java.lang.String getTimeIndeterminateValueTypeValue(){
  		return TimeIndeterminateValueTypeValue; 	
  	} 
	public boolean isTimeIndeterminateValueTypeValueSet(){
  		return isTimeIndeterminateValueTypeValueSet;
  	} 	
   public void processString(String content) throws IllegalConvertionException{
	   	boolean convertSuccess = false;		 		
		/*if (!convertSuccess){
			try{
				dateValue = new DateTime(content);
				convertSuccess = true;
				isDateValueSet = true;
			}
			catch(Exception e){
			
			}
		}
		if (!convertSuccess){
			try{
				timeValue = new DateTime(content);
				convertSuccess = true;
				isTimeValueSet = true;
			}
			catch(Exception e){
			
			}
		}*/
		if (!convertSuccess){
			try{
				dateTimeValue = content;//new DateTime(content);
				convertSuccess = true;
				isDateTimeValueSet = true;
			}
			catch(Exception e){
			   convertSuccess = false;
			}
		}
		if (!convertSuccess){
			try{
				TimeIndeterminateValueTypeValue = content;
				convertSuccess = true;
				isTimeIndeterminateValueTypeValueSet = true;
			}
			catch(Exception e){
			  convertSuccess = false;
			}
		}
		
		if (!convertSuccess)
			throw new IllegalConvertionException();
	}	
	
}
		
