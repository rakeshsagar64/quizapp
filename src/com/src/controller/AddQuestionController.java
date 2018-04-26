package com.src.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.model.Questions;
import com.src.services.FactoryClass;

@WebServlet("/AddQuestionController")
public class AddQuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestionController() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session=request.getSession(false);
		if(session!=null){
		String question=request.getParameter("question");
		String optionA=request.getParameter("option_a");
		String optionB=request.getParameter("option_b");
		String optionC=request.getParameter("option_c");
		String optionD=request.getParameter("option_d");
		String correctAnswer=request.getParameter("correctanswer");
		
		String[] optionArray={optionA,optionB,optionC,optionD};
		Questions q=new Questions(question,optionArray,correctAnswer,true);
		
		try {
			FactoryClass.getAdminInstance().addQuestions((String)session.getAttribute("subjectName"), q);
			request.getRequestDispatcher("QuestionCaller").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		else{
			
			
			
		}
	}

}
