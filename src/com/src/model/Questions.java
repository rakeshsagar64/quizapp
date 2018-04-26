package com.src.model;
/*
 * model class for admin controller 
 * where admin add questions to the db
 * 
 * */
public class Questions {
	
	private int questionId;
	private String question;
	private String[] options;
	private String correctAns;
	private boolean isImportant;
	
	public Questions(int questionId, String question,String[] options,String correctAns,boolean isImportant){
		
		this.setQuestionId(questionId);
		this.question=question;
		this.options=options;
		this.correctAns=correctAns;
		this.isImportant=isImportant;
		
		
	}
	
	
	
	
	
	public Questions(String question,String[] options,String correctAns,boolean isImportant){
		this.question=question;
		this.options=options;
		this.correctAns=correctAns;
		this.isImportant=isImportant;
		
		
	}
	
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String[] getOptions() {
		return options;
	}
	
	public void setOptions(String[] options) {
		this.options = options;
	}
	
	public String getCorrectAns() {
		return correctAns;
	}
	
	public void setCorrectAns(String correctAns) {
		this.correctAns = correctAns;
	}
	
	public boolean isImportant() {
		return isImportant;
	}
	
	public void setImportant(boolean isImportant) {
		this.isImportant = isImportant;
	}





	public int getQuestionId() {
		return questionId;
	}





	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
}
