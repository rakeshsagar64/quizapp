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

@WebServlet("/AddSubject")
public class AddSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddSubject() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		doPost(request,response);
    
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		
		if(session!=null){
		String subjectName=request.getParameter("subject");
		try {
		boolean outcome=FactoryClass.getAdminInstance().addSubjects(subjectName);
		
		if(outcome){
		session.setAttribute("subjectList",FactoryClass.getInstance().fetchSubjectList());
			request.setAttribute("message","subject added successfully");
			
		}
		else{
			request.setAttribute("message","failed to add the subject");
			
		}
		request.getRequestDispatcher("WEB-INF/admincontrols.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		else{
			request.getRequestDispatcher("AdminCaller").forward(request, response);
			
			
		}
	
	}

}
