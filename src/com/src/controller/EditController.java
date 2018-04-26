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

/*
  -------------------------------------class summary-------------------------------------------
  takes the subject name from edit question drop down menu and fetches all the questions from the 
  database and redirects it to questions list
   
  ---------------------------------Attribute list------------------------------------------------
  request--get-->coursename (gets coursename from edit question dropdown)
  session--set-->questions (sets the questions fetched from the database to the session scope)
  
  -----------------------------------------------------------------------------------------------
  */
@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession(false);
		if(session!=null){
		try {
			
			String subjectName=request.getParameter("coursename");
			
			
			if(subjectName.equalsIgnoreCase("Select")){
				request.setAttribute("error", "select a subject");
				request.getRequestDispatcher("WEB-INF/admincontrols.jsp").forward(request, response);
								
			}
			else{
				session.setAttribute("subjectName",subjectName);
				System.out.println(subjectName+" in EditController");
				session.setAttribute("questions",FactoryClass.getAdminInstance().fetchAllQuestion((String)session.getAttribute("subjectName")));
				request.getRequestDispatcher("WEB-INF/questions.jsp").forward(request, response);
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//add subjects here	
		}
		else{
			request.getRequestDispatcher("AdminCaller").forward(request, response);
			
			
		}
		
	}

}
