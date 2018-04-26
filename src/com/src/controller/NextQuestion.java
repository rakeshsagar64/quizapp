package com.src.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.model.Questions;

@WebServlet("/NextQuestion")
public class NextQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NextQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		String s=request.getParameter("answer");
		
		if(session==null){
			request.getRequestDispatcher("IndexController").forward(request, response);
			
			
		}
		else{
			Long correctAnswer=(Long)session.getAttribute("correctAnswer");			
			Long maxCount=(Long) session.getAttribute("questionCount");
			Long currentCount=(Long) session.getAttribute("currentCount");
			HashMap<Long,Questions> questions=(HashMap<Long, Questions>) session.getAttribute("questionList");
			
			
			Questions q=questions.get(currentCount);
			
			
			if(currentCount<=maxCount){
				System.out.println(s);
				if(q.getCorrectAns().equalsIgnoreCase(s)){
				
					System.out.println(correctAnswer);
					correctAnswer=correctAnswer+1;
				
				}
				else{
							
				
				}
			
				currentCount=currentCount+1;
				session.setAttribute("correctAnswer",correctAnswer);
				session.setAttribute("currentCount",currentCount);
				request.setAttribute("question",q);
				request.getRequestDispatcher("WEB-INF/quiz.jsp").forward(request, response);
			
			}
			else{
				session.setAttribute("correctAnswer",correctAnswer);
				request.getRequestDispatcher("WEB-INF/result.jsp").forward(request, response);
							
			}
			
		}
	}

}
