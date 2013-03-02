package org.gvsig.sos.lib.impl.parsers.swe_1_0_1;

import org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.IllegalConvertionException;


public class timePositionType implements org.gvsig.sos.lib.impl.parsers.xsdgenerator.parser.XMLSimpleTypeContent {
	//Fields Section

		private org.gvsig.sos.lib.impl.parsers.swe_1_0_1.timeIso8601 timeIso8601Value;
		boolean isTimeIso8601ValueSet = false;
		private Double doubleValue;
		boolean isDoubleValueSet = false;
  	
	public timePositionType(){
	}	
	public timePositionType(String union) throws IllegalConvertionException{
		processString(union);
	}
	
	  	public void setTimeIso8601Value(org.gvsig.sos.lib.impl.parsers.swe_1_0_1.timeIso8601 value){
  		this.timeIso8601Value = value;
  	}	
  	public org.gvsig.sos.lib.impl.parsers.swe_1_0_1.timeIso8601 getTimeIso8601Value(){
  		return timeIso8601Value; 	
  	} 
	public boolean isTimeIso8601ValueSet(){
  		return isTimeIso8601ValueSet;
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
   public void processString(String content) throws IllegalConvertionException{
	   	boolean convertSuccess = false;		 		
		if (!convertSuccess){
			try{
				timeIso8601Value = new  org.gvsig.sos.lib.impl.parsers.swe_1_0_1.timeIso8601();
				timeIso8601Value.processString(content);
				convertSuccess = true;
				isTimeIso8601ValueSet = true;
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
		
		if (!convertSuccess)
			throw new IllegalConvertionException();
	}	
	
}
		
