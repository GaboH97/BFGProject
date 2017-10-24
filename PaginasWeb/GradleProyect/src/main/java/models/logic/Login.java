package models.logic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		 
		String user=request.getParameter("userName");
		String pass=request.getParameter("userPassword");
		 
		if(user.equals("edwin")&&pass.equals("123")){
			System.out.println("si entro la perra");
			pw.println("Login Success...!");
		} else {
			pw.println("Login Failed...!");
			pw.close();
		}			
	}

}
