package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.LoginDao;


@WebServlet("/Login")
public class Login extends HttpServlet {
	
	//creating object of login dao 
	LoginDao dao = new LoginDao();
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		/*fetching values from deployment discriptor
		
		ServletContext ctx = getServletContext();
		String username = ctx.getInitParameter("username");
		String password = ctx.getInitParameter("password");
		
		
		
		//condition checking
		
		if( uname.equals(username) && pass.equals(password))
		{
			out.println("Welcome "+username);
			
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("Welcome.jsp");
			
		} 
		
		*/
		
		try 
		{
			if( dao.check(uname, pass) )
			{
				out.println("Welcome "+uname);
				
				HttpSession session = request.getSession();
				session.setAttribute("username", uname);
				response.sendRedirect("Welcome.jsp");
				
			}
			
			
			else
			{
				out.println("user name or password is invalid... <br><hr>" );
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.include(request, response);
			}
		
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
