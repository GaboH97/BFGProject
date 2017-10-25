package models.logic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 * This class handles doPost/DoGet requests from running server
 * (By default, Server runs at http://localhost:8080)
 * via HTTP protocol. It also responds request either by returning specific
 * values or loading .JSP files when accessing to another interfaces.
 *  
 *  @author Juan Diego Molina, Cesar Cardozo, Gabriel Huertas
 * 
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Inherited method that responds to requests using doPost method
	 * This method is triggered by the Login form action, then input
	 * data for username/password credential is requested, checked for
	 * for any matches in the DBMS and responds loading a success or fail
	 * message.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *      
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		String user = request.getParameter("userName");
		String pass = request.getParameter("userPassword");
		Manager manager = new Manager();
		if (manager.userExist(user, pass)) {
			RequestDispatcher rdp = request.getRequestDispatcher("/success.html");
			rdp.forward(request, response);
			pw.println("Login Sucess..!");

		} else {
			RequestDispatcher rdp = request.getRequestDispatcher("/error.html");
			rdp.forward(request, response);
			pw.println("Login Failed...!");
			pw.close();
		}
	}
}