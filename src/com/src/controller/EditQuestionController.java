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
/*
--------------------------------class summary-----------------------------------------
sends the data in the form to the editQuestion() in adminImpl
 
----------------------------------attribute-------------------------------------------
			session--get-->subjectName
			


-------------------------------------------------------------------------------------
 */



@WebServlet("/EditQuestionController")
public class EditQuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public EditQuestionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession(false);
			if(session==null){
				request.getRequestDispatcher("AdminCaller").forward(request, response);
				
				
			}
			else{
				String subjectName=(String)session.getAttribute("subjectName");
				System.out.println(subjectName);
				String question=request.getParameter("question");
				String option_a=request.getParameter("option_a");
				String option_b=request.getParameter("option_b");
				String option_c=request.getParameter("option_c");
				String option_d=request.getParameter("option_d");
				String correctAns=request.getParameter("correctanswer");
				String[] array={option_a,option_b,option_c,option_d};
				Questions q=new Questions(question,array,correctAns,true);
				try {
					
					int rowsUpdated=FactoryClass.getAdminInstance().editQuestion(subjectName, q);
					if(rowsUpdated>0){
						request.setAttribute("message", "success "+rowsUpdated+" question updated");
						
					}
					else{
						
						request.setAttribute("message", "update failed");
						
						
					}
					request.getRequestDispatcher("QuestionCaller").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
	
	}

}
