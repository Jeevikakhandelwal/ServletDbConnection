package com.abc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.abc.dto.UserDto;

public class UserService {

	private static final String SQL_SELECT_QUERY = "select username, password from UserDetails where username=? and password=?";
	Connection connection = null;
	PreparedStatement pstmt = null;
	Statement statement = null;
	ResultSet resultSet = null;

	public UserService() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Manually loading JVM 
			connection = DriverManager.getConnection("jdbc:mysql:///personinfo", "root", "root");
			// statement = connection.createStatement();
			pstmt = connection.prepareStatement(SQL_SELECT_QUERY);
			statement= connection.createStatement();
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Service of checking login credentials
	public boolean checkLogin(String username, String password) {
		System.out.println("UserService.checkLogin()");
		try {
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// Service for checking Registration credentials
	public boolean registerData(UserDto user) {
		System.out.println("UserService.register()");
		try {
			String SQL_INSERT_QUERY=String.format(
					"Insert into UserDetails(username, password, uemail, umoblie) values('%s','%s','%s','%s')",
					 user.getUsername(),user.getPassword(),user.getUemail(),user.getUmobile());
			
			
			int rowAffected=statement.executeUpdate(SQL_INSERT_QUERY);
			if(rowAffected>0){
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
