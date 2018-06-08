package com.src.services;

import java.io.IOException;
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
import java.util.Properties;

import com.src.model.Question;
import com.src.model.Questions;
import com.src.model.Student;

public class QuizImpl implements QuizIntr {

	private static Connection con;
	
	static{
		try {
			Properties p=new Properties();
			p.load(QuizImpl.class.getResourceAsStream("db.properties"));
			Class.forName(p.getProperty("driver"));
			con=DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
	
	
	public List<Question> fetchQuestion(String courseName) throws SQLException{
		courseName=courseName.replace(" ", "_");
		Statement stmt=con.createStatement();
		String query="select * from "+courseName;
		System.out.println("OuizImpl.fetchQuestion-->"+query);
		
		ResultSet rs=stmt.executeQuery(query);
		
		List<Question> questions=new ArrayList<>();
		long count=1;
	
		while(rs.next()){
			String question=rs.getString("question");
		//adds to an object of the question class contining the data from the result set
			String[] options={rs.getString("option_1"),rs.getString("option_2"),rs.getString("option_3"),rs.getString("option_4")};
			String answer=rs.getString("correct_ans");
			Question q=new Question();
			q.setQuestion(question);
			q.setChoices(options);
			q.setCorrectAnswer(answer);
			questions.add(q);
		}
		
		return questions;
		
	}


	@Override
	public int insertStudent(Student s) throws SQLException {
		String query="insert into student_table values(null,?,?,?,?,?,?,?,curdate())";
		System.out.println(query);
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, s.getName());
		ps.setString(2,s.getQualification());
		ps.setString(3, s.getSpecialization());
		ps.setInt(4, s.getYearOfCompletion());
		ps.setString(5, s.getEmail());
		ps.setString(6, s.getContactNo());
		ps.setString(7, s.getCourseName());
		return ps.executeUpdate();
	}
	
	
}
