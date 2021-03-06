package com.src.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.src.model.Question;
import com.src.model.Questions;
import com.src.model.Student;

public interface QuizIntr {
	
	public List<Question> fetchQuestion(String courseName) throws SQLException;
	public List<String> fetchSubjectList() throws SQLException;
	
	public int insertStudent(Student s) throws SQLException;
}

