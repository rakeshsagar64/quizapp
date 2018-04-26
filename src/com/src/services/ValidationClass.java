package com.src.services;

public class ValidationClass {

	
	private ValidationClass(){
		
		
	}
	
	
	public static boolean checkEmpty(String data){
		
		boolean valid=false;
			if(data==null){
				valid=false;
				
			}
			else if(data.trim().length()<=0){
				
				valid=false;
			}
			else{
				
				valid=true;
				
			}
		return valid;
		
	}
	
	
	
}
