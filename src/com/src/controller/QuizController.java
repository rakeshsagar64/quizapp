package com.src.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		
		
		HttpSession session=request.getSession(false);
		String courseName=(String)session.getAttribute("courseName");
		Gson g=new Gson();
		
		try {
			List<Question> question = FactoryClass.getInstance().fetchQuestion(courseName);

			String json = g.toJson(question);
			System.out.println(json);
			response.getWriter().write(json);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
