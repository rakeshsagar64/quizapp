package com.src.services;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.src.model.AdminLogin;
import com.src.model.Questions;

public class AdminImpl implements AdminIntr {

	
	private static Connection con;

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Properties p=new Properties();
			//p.load(new FileReader("data.properties"));
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_app","root","rakesh666");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
	

	public boolean addSubjects(String subjectName) throws SQLException{
		
		//method to add subjects to the exam
		//must insert into the subject table and create table with the subject name
		String subjectTableName=subjectName.replace(" ", "_");
		String insertQuery="insert into subject_table values(null,'"+subjectName+"')";
		String createQuery="create table "+subjectTableName+"(id int not null auto_increment primary key,question text(20000),option_1 text(20000),option_2 text(20000),option_3 text(20000),option_4 text(20000),correct_ans text(20000),important boolean)";
		System.out.println(insertQuery);
		System.out.println(createQuery);
		
		con.setAutoCommit(false);
		Statement stmt=con.createStatement();
		int outcome1=stmt.executeUpdate(insertQuery);
		boolean outcome2=stmt.execute(createQuery);
		
		
		con.commit();
		System.out.println(outcome1);
		System.out.println(outcome2);
		if((outcome1>0)&&(!outcome2)){//the outcome2 must be true but getting false temp fix
			
			return true;
		}
		else{
			con.rollback();
			return false;
					
		}
		
		
	}
	//displays aall questions for the edit page
	
	public List<Questions> fetchAllQuestion(String subject) throws SQLException{
		subject=subject.replace(" ", "_");
		String query ="select * from "+subject;
		System.out.println("AdminImpl.fetchAllQuestions--->"+query);
		
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		List<Questions> data=new ArrayList<>();
		
		//inserts all the data iinto the collecctions
		while(rs.next()){
			String[] options={rs.getString("option_1"),rs.getString("option_2"),rs.getString("option_3"),rs.getString("option_4")};
			data.add(new Questions(rs.getInt("id"), rs.getString("question"), options, rs.getString("correct_ans"),rs.getBoolean("important")));
		
		}
		return data;
		
	}
	
	
	public int addQuestions(String subjects,Questions q) throws SQLException{
		//method to add question into the table
		subjects=subjects.replace(" ", "_");
		String insertQuestion="insert into "+subjects+" values(null,?,?,?,?,?,?,?)";
		System.out.println("add question module "+insertQuestion);
		System.out.println(q.getQuestion());
		String[] options=q.getOptions();
		
		PreparedStatement ps=con.prepareStatement(insertQuestion);
		
		ps.setString(1, q.getQuestion());
		ps.setString(2, options[0]);
		ps.setString(3, options[1]);
		ps.setString(4, options[2]);
		ps.setString(5, options[3]);
		ps.setString(6, q.getCorrectAns());
		ps.setBoolean(7,q.isImportant());
		
		int outcome=ps.executeUpdate();
			System.out.println(outcome);
		return outcome;
	}
	
	public int editQuestion(String subjects,Questions q) throws SQLException{
		//must perform updaet operations
		subjects=subjects.replace(" ","_");
		String[] optionArray=q.getOptions();
		String editQuestion="update "+subjects+" set question = '"+q.getQuestion()+"',option_1= '"+optionArray[0]+"',option_2='"+optionArray[1]+"',option_3='"+optionArray[2]+"',option_4='"+optionArray[3]+"',correct_ans='"+q.getCorrectAns()+"' where question='"+q.getQuestion()+"';";
		System.out.println("edit question module "+editQuestion);
		System.out.println(q.getQuestion());
		String[] options=q.getOptions();
		
		Statement stmt =con.createStatement();
		int outcome=stmt.executeUpdate(editQuestion);
			System.out.println(outcome);
		return outcome;
		
		
		
	}

	@Override
	public boolean isValidUser(AdminLogin am) throws SQLException {
		
		String query="select * from registration where username='"+am.getUsername()+"' and password='"+am.getPassword()+"';";
		System.out.println(query);
		
		Statement statement = con.createStatement();
		
		ResultSet resultSet = statement.executeQuery(query);
		List<String> data=new ArrayList<>();
			
		while(resultSet.next()){
				data.add(resultSet.getString("username"));
				
			}
			if(data.isEmpty()){
			return false;	
			
		}
		else{
			return true;
			
		}
		
	}
}
