package com.src.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		QuizIntr qi=FactoryClass.getInstance();
		try {
			
			Map<Long,Questions>questionList=qi.fetchQuestion(courseName);
			long questionCount=(long)questionList.keySet().size();
			Long currentCount=new Long(1);
			long answer=0;
			System.out.println("setting question list "+questionList);
			session.setAttribute("correctAnswer",answer);
			session.setAttribute("questionCount",questionCount);
			session.setAttribute("currentCount",currentCount);
			session.setAttribute("questionList",questionList);
			
			request.getRequestDispatcher("NextQuestion").forward(request, response);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
