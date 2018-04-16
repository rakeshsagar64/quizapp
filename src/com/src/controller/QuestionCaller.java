package com.src.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.services.FactoryClass;

/**
 * Servlet implementation class QuestionCaller
 */
@WebServlet("/QuestionCaller")
public class QuestionCaller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuestionCaller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession(false);
		if(session==null){
			request.getRequestDispatcher("AdminCaller").forward(request, response);
				
		}
		else{
			
			try {
				session.setAttribute("questions",FactoryClass.getAdminInstance().fetchAllQuestion((String)session.getAttribute("subjectName")));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("WEB-INF/questions.jsp").forward(request, response);

			
		}
		
		
	}

}
