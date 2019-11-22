package com.RentMyCar;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String message = req.getParameter("message");
		System.out.println(req.getParameter(message));
		try {
			writeToDatabase(message);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void writeToDatabase(String message) throws ClassNotFoundException {
		try {
			//Class.forName("com.mysql.jdbc");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/messages?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin", "root", "RentMyCar2019");
			Statement statement = conn.createStatement();
			
			String insert = "insert into messages(message) values ('" + message + "')";
			
			statement.executeUpdate(insert);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	

	
}
