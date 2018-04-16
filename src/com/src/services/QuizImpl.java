package com.src.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.src.model.Questions;

public class QuizImpl implements QuizIntr {

	private static Connection con;

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_app","root","rakesh666");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
			
		
	}
	
	
	public List<String> fetchSubjectList() throws SQLException{
		
		Statement stmt=con.createStatement();
		String query="select * from subject_table";
		System.out.println(query);
		List<String> data=new ArrayList<>();
		ResultSet rs=stmt.executeQuery(query);
		
		while(rs.next()){
			data.add(rs.getString("subject_name"));
			
			
		}
		return data;
	}
	
	
	//method to fetch the question sfrom the database
	//converts the resultSet into a List of questions and sends it to the frontEnd
	
	
	public Map<Long,Questions> fetchQuestion(String courseName) throws SQLException{
		
		Statement stmt=con.createStatement();
		String query="select * from "+courseName;
		System.out.println(query);
		
		ResultSet rs=stmt.executeQuery(query);
		
		Map<Long,Questions> questions=new HashMap<>();
		long count=1;
	
		while(rs.next()){
		//adds to an object of the question class contining the data from the result set
			String[] options={rs.getString("option_1"),rs.getString("option_2"),rs.getString("option_3"),rs.getString("option_4")};
				
			questions.put(count,new Questions(rs.getString("question"),options,rs.getString("correct_ans"),rs.getBoolean("important")) );	
			count++;
		}
		
		return questions;
		
	}
	
	
}
