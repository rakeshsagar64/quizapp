package com.src.services;

public class FactoryClass {

	private FactoryClass(){
		
		
		
	}
	
	private static QuizIntr qi;
	
	public static QuizIntr getInstance(){
		qi=new QuizImpl();
		return qi;
		
		
	} 
	
	private static AdminIntr ai; 
	
	public static AdminIntr getAdminInstance(){
		ai=new AdminImpl();
		return ai;
		
		
	}
	
}
