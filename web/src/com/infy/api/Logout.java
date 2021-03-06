package com.infy.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		
		HttpSession httpSession= request.getSession(false);
		
		if(httpSession==null)
		{
			response.sendRedirect("Signin.html");
		}
		else
		{
		httpSession.removeAttribute("User");
	httpSession.invalidate();
	
	response.sendRedirect("Signin.html");
	
		}
	
	
	
	
	}

}
