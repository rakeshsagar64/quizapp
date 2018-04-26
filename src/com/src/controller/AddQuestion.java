package com.src.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddQuestion")
public class AddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjectName=request.getParameter("coursename");
		HttpSession session=request.getSession(false);
		if(session==null){
			request.getRequestDispatcher("AdminCaller").forward(request, response);
			
		}
		else{
			
			if(subjectName.equalsIgnoreCase("Select")){
				request.setAttribute("error", "select a subject");
				request.getRequestDispatcher("WEB-INF/addcontrols.jsp").forward(request, response);
								
			}
			else{
				session.setAttribute("subjectName",subjectName);
				request.getRequestDispatcher("WEB-INF/addquestion.jsp").forward(request, response);
			}
		}
	}

}
