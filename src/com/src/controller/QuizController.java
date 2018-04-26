package com.src.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.src.model.Question;
import com.src.model.Questions;
import com.src.services.FactoryClass;
import com.src.services.QuizIntr;


@WebServlet("/QuizController")
public class QuizController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public QuizController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");//to-do validation for name field
		String courseName=request.getParameter("coursename");//to-do check the course name
		
		HttpSession session=request.getSession();
		
		Gson g=new Gson();
		Question q=new Question();
		q.setQuestion("Queston?");
		String[] s= {"option 1","optoin 2","option 3","option 4"};
		q.setChoices(s);
		q.setCorrectAnswer("option 1");
		
		Question q1=new Question();
		q1.setQuestion("Queston?");
		String[] s1= {"option 1","optoin 2","option 3","option 4"};
		q1.setChoices(s);
		q1.setCorrectAnswer("optoin 2");
		
		Question q2=new Question();
		q2.setQuestion("Queston?");
		String[] s2= {"option 1","optoin 2","option 3","option 4"};
		q2.setChoices(s);
		q2.setCorrectAnswer("option 1");
		
		ArrayList<Question> ar=new ArrayList<>();
		ar.add(q);
		ar.add(q1);
		ar.add(q2);
		
		String json = g.toJson(ar);
		System.out.println(json);
		response.getWriter().write(json);
		
		

	}

}
