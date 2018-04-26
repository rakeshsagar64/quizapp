package com.src.listener;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import com.src.services.FactoryClass;

/**
 * Application Lifecycle Listener implementation class SubjectListListener
 *
 */
@WebListener
public class SubjectListListener implements ServletContextListener{

    /**
     * Default constructor. 
     */
    public SubjectListListener() {
        // TODO Auto-generated constructor stub
    }


    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	ServletContext context = arg0.getServletContext();
		try {
			context.setAttribute("subjectList",FactoryClass.getInstance().fetchSubjectList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
