package com.RentMyCar;

import java.io.IOException;
import java.io.InputStream;


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
	private static String dbURL = "jdbc:mysql://localhost:3306/rentmycar?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
	private static String dbUser = "root";
	private static String dbPass = "RentMyCar2019";
	
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

		
		InputStream inputStream = null;	// input stream für das Hochladen der Fotos
		
		// übertragen der multipart upload in das inputstream
		Part filePart = request.getPart("photo");
		if (filePart != null) {
			// prints out some information for debugging
			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());
			
		
			inputStream = filePart.getInputStream();
		}
		String message = DatabaseConnection.writetoDatabase(car1, inputStream);

			// Message für die request scope machen
			request.setAttribute("Message", message);
			
			// Zur Ergebniss Seite wechseln
			getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}
