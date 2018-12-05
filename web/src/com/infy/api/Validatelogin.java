package com.infy.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.infy.bean.User;
import com.infy.business.service.UserService;
import com.infy.dao.UserDAO;
import com.infy.resources.Factory;

import javafx.scene.control.Alert;

/**
 * Servlet implementation class Validatelogin
 */
@WebServlet("/validate")
public class Validatelogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validatelogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uName = request.getParameter("username");
        String pass = request.getParameter("password");
        response.setContentType("text/html");
        PrintWriter  out=response.getWriter();
      
 
        		try {
        			
        		
        	UserService service=Factory.createUserService();
        	
        	User user=service.findUser(uName);
        	
        	
        	
        	if(user!=null && user.getPassword().equals(pass))
        	{
        		
        		HttpSession httpSession= request.getSession();
        		httpSession.setAttribute("uName", uName);
        		httpSession.setMaxInactiveInterval(30*60);
        	
        		Cookie userName = new Cookie("uName", uName);
    			userName.setMaxAge(30*60);
    			response.addCookie(userName);
    		
    			
        	
    			
        		response.sendRedirect("NewFile.jsp");
        	
        		
        	}
        	else
        	{
        		
        		
        		
        		
        	
        		request.getRequestDispatcher("/Signin.html").forward(request, response);
        		
        		
        	}
        		}catch (Exception e) {
        			DOMConfigurator.configure("src/com/infy/resources/log4j.xml");
    				Logger logger = Logger.getLogger(this.getClass());
    				logger.error(e.getMessage(), e);
        		
					// TODO: handle exception
				}
       
	}

}
