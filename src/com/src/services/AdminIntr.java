package com.src.services;

import java.sql.SQLException;
import java.util.List;

import com.src.model.AdminLogin;
import com.src.model.Questions;

public interface AdminIntr {

	public boolean addSubjects(String subjectName) throws SQLException;
	
	public int addQuestions(String subjects,Questions q) throws SQLException;
	
	public int editQuestion(String subjects,Questions q) throws SQLException;
	
	public List<Questions> fetchAllQuestion(String subject) throws SQLException;

	public boolean isValidUser(AdminLogin am) throws SQLException;
}
