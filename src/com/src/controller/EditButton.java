package com.src.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.model.Questions;

/*
------------------------------------Class Summary------------------------------------- 
fetches the question id from the edit button as a parameter
then searches the listfrom session scope based on the id 
sets the fetched question as a parameter in request scope and sends it to editquestion.jsp
in edit question.jsp form repopulation is done with the data

------------------------------------Attributes---------------------------------------
request----set---->questiontoedit (object of the question class)
session----get---->questions (list of questions in the subject)

--------------------------------------------------------------------------------------

*/



@WebServlet("/EditButton")
public class EditButton extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditButton() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s=request.getParameter("questionId");
		System.out.println(s);
		HttpSession session=request.getSession(false);
		if(session==null){
			request.getRequestDispatcher("AdminCaller").forward(request, response);
			
		}
		else{
			
			//fetches the question id from the edit button as a parameter
			//then gets the question object from the id 
			List<Questions> question=(List<Questions>) session.getAttribute("questions");
			//sets the fetched question as a parameter in request scope and sends ti to editquestion.jsp
			
			request.setAttribute("questiontoedit", question.get(Integer.parseInt(s)));
			request.getRequestDispatcher("WEB-INF/editquestion.jsp").forward(request, response);
			
		}
	}

}
