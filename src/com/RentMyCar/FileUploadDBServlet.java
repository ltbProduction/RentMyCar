package com.RentMyCar;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)	// upload file's size up to 16MB
public class FileUploadDBServlet extends HttpServlet {
	
	// database connection settings
	private String dbURL = "jdbc:mysql://localhost:3306/rentmycar?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
	private String dbUser = "root";
	private String dbPass = "RentMyCar2019";
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// gets values of text fields
		
		CarElement car1 = new CarElement(
				request.getParameter("firstName"),
				request.getParameter("lastName"),
				request.getParameter("location"), 
				request.getParameter("email"),
				request.getParameter("phone"), 
				request.getParameter("brand"),
				request.getParameter("type"),
				request.getParameter("fuel"),
				request.getParameter("description"),
				Double.parseDouble(request.getParameter("price")));

		
		InputStream inputStream = null;	// input stream of the upload file
		
		// obtains the upload file part in this multipart request
		Part filePart = request.getPart("photo");
		if (filePart != null) {
			// prints out some information for debugging
			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());
			
			// obtains input stream of the upload file
			inputStream = filePart.getInputStream();
		}
		
		Connection conn = null;	// connection to the database
		String message = null;	// message will be sent back to client
		//int car_id = 0;
		
		try {
			// connects to the database
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

			// constructs SQL statement
			String sql = "INSERT INTO carelement (firstName, lastName, location, email, phonenumber, carbrand, cartyp, fueltyp, price, description_text, photo) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, car1.getFirstName());
			statement.setString(2, car1.getLastName());
			statement.setString(3, car1.getLocation());
			statement.setString(4, car1.getMail());
			statement.setString(5, car1.getPhonenumber());
			statement.setString(6, car1.getBrand());
			statement.setString(7, car1.getType());
			statement.setString(8, car1.getFuel());
			statement.setString(9, String.valueOf(car1.getPrice()));
			statement.setString(10, car1.getDescription());	
			

			
			if (inputStream != null) {
				// fetches input stream of the upload file for the blob column
				statement.setBlob(11, inputStream);
			}

			// sends the statement to the database server
			int row = statement.executeUpdate();
			if (row > 0) {
				message = "File uploaded and saved into database";
				
				
				/*
				 * Statement statement_id = conn.createStatement(); String id_query =
				 * "SELECT MAX(element_id) FROM carelement"; ResultSet result =
				 * statement_id.executeQuery(id_query); if (result.next()) { car_id =
				 * result.getInt(1); }
				 */
				 

				
			}
		} catch (SQLException ex) {
			message = "ERROR: " + ex.getMessage();
			ex.printStackTrace();
		} finally {
			if (conn != null) {
				// closes the database connection
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			// sets the message in request scope
			request.setAttribute("Message", message);
			
			// forwards to the message page
			getServletContext().getRequestDispatcher("/Upload.jsp").forward(request, response);
		}
	}
}