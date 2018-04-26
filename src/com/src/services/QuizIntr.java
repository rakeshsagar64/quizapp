package com.src.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.src.model.Questions;

public interface QuizIntr {
	
	
	public Map<Long,Questions> fetchQuestion(String courseName) throws SQLException;
	
	public List<String> fetchSubjectList() throws SQLException;
	
	
}

