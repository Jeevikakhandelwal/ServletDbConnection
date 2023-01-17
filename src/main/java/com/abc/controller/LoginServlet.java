package com.abc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.dao.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Setting MIME response
		response.setContentType("text/html");

		// Getting PrintWriter Stream object to write the response
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Response</title></head>");
		out.println("<body>");

		// Collecting the request parameter data
		String username = request.getParameter("username");
		String upwd = request.getParameter("upwd");

		// Creating an object making a call to UserService checkLogin() method
		UserService service = new UserService();
		boolean status = service.checkLogin(username, upwd);

		// Processing the status sent by the service layer
		if (status) {
			out.println("<h1 style='color:green; text-align:center;'>LOGIN SUCCESFULL</h1>");
		} else {
			out.println("<h1 style='color:red; text-align:center;'>LOGIN FAILURE</h1>");
			out.println("<h1 style='color:blue; text-align:center;'><a href='Loginform.html'>|LOGINPAGE|</a></h1>");
		}

		out.println("</body>");
		out.println("</html>");
		// Closing stream
		out.close();
	}

}
