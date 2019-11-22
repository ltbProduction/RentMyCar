package com.RentMyCar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontEndConnectionServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String message = req.getParameter("message");
		System.out.println(req.getParameter(message));
		System.out.println("asd");
		try {
			DatabaseConnection.writeToDatabase(message);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
