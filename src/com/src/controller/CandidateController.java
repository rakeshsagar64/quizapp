package com.src.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.model.Student;
import com.src.services.FactoryClass;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory;

/**
 * Servlet implementation class CandidateController
 */
@WebServlet("/CandidateController")
public class CandidateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO take student details and store in db
		//TODO create session
		
		//TODO form validation
		
		String name = request.getParameter("name");
		String qualification = request.getParameter("qualification");
		String specialization = request.getParameter("specialization");
		String email = request.getParameter("email");
		String yearOfPassing = request.getParameter("yearOfPassing");
		String contactNo = request.getParameter("contactNo");
		String courseName = request.getParameter("coursename");
		
		Student s=new Student();
		s.setName(name);
		s.setQualification(qualification);
		s.setSpecialization(specialization);
		s.setEmail(email);
		s.setCourseName(courseName);
		
		s.setYearOfCompletion(Integer.parseInt(yearOfPassing));
		s.setContactNo(contactNo);
		
		try {
			FactoryClass.getInstance().insertStudent(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session=request.getSession(true);
		session.setAttribute("courseName",courseName);
		//TODO RECIEVE subject name in quiz controller
		
		
		request.getRequestDispatcher("WEB-INF/quiz.jsp").forward(request, response);
		
	}

}
