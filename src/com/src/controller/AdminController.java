package com.src.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.model.AdminLogin;
import com.src.services.FactoryClass;


@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//must validate admin login
		String username=request.getParameter("username");
		String password =request.getParameter("password");
		
		AdminLogin am=new AdminLogin();
		am.setPassword(password);
		am.setUsername(username);
	try {
		if(FactoryClass.getAdminInstance().isValidUser(am)){	
			
			HttpSession session =request.getSession();
			session.setAttribute("subjectList", FactoryClass.getInstance().fetchSubjectList());
			
			request.getRequestDispatcher("WEB-INF/admincontrols.jsp").forward(request, response);
		
		
		}
		else{
			request.setAttribute("message","Invalid username or password");
			request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	}

}
