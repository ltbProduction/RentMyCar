package com.RentMyCar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontEndConnectionServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String message = req.getParameter("kast");
//		System.out.println(message);
	
		//Create new CarElement
		CarElement car1 = new CarElement(
				req.getParameter("name"), 
				req.getParameter("ort"), 
				req.getParameter("email"),
				req.getParameter("phonenumber"), 
				req.getParameter("brand"),
				req.getParameter("type"),
				req.getParameter("fuel"),
				req.getParameter("description"),
				Double.parseDouble(req.getParameter("price")));
		
		try {
			DatabaseConnection.writeToDatabase(car1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public void writecarelements(ArrayList<CarElement> cars) {
//		for (cars c : )
//	}
	
}
