package com.abc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.dao.UserService;
import com.abc.dto.UserDto;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting MIME response to the client
		response.setContentType("text/html");
		
		//Getting PrintWriter Stream to write the response in ResponseObject
		PrintWriter out=response.getWriter();
		
		out.println("<html><head><title></title></head>");
		out.println("<body>");
		
		//Collecting Parameter names from RequestObject
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		String uemail=request.getParameter("uemail");
		String umoblie=request.getParameter("umobile");
		
		//Creating a DTO to send the value to the DAO
		UserDto user= new UserDto();
		user.setUsername(uname);
		user.setPassword(upwd);
		user.setUemail(uemail);
		user.setUmobile(umoblie);
		
		//Create an object of DAO and pass this object and wait for the response
		UserService userService=new UserService();
		boolean status =userService.registerData(user);
		
		if(status) {
			out.println("<h1 style='color:green; text-align:center;'>Registration Sucessfull<h1>");
		}else {
			out.println("<h1 style='color:red; text-align:center;'>Registration failure</h1>");
			out.println("<h1 style='color:blue text-align:center;'><a href='RegistrationForm.html'>|REGISTATIONFORM|</a></h1>");
		}
		
		
		out.println("</body>");
		out.println("</html>");
		//Closing Stream
		out.close();
	}

}
