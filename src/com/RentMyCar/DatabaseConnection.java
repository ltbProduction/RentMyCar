package com.RentMyCar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;

public class DatabaseConnection {
	private static String url = "jdbc:mysql://localhost:3306/rentmycar?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";


	public static ArrayList<CarElement> readfromDatabase() throws Exception {
		ArrayList<CarElement> cars = new ArrayList<CarElement>();
		try {
			// create our mysql database connection
			Connection conn = DriverManager.getConnection(url, "root", "RentMyCar2019");

			// our SQL SELECT query.
			// if you only need a few columns, specify them by name instead of using "*"
			String query = "SELECT * FROM carelement";

			// create the java statement
			Statement st = conn.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next()) {

				CarElement ce = new CarElement();

				Integer elementid = rs.getInt("element_id");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String location = rs.getString("location");
				String mail = rs.getString("email");
				String phonenumber = rs.getString("phonenumber");
				String brand = rs.getString("carbrand");
				String type = rs.getString("cartyp");
				String fuel = rs.getString("fueltyp");
				String description = rs.getString("description_text");
				Double price = rs.getDouble("price");
				Blob blob = rs.getBlob("photo");
				Date created_at = rs.getDate("created_at");

				// Umwandlung von Blob in String
				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				inputStream.close();
				outputStream.close();
				ce.setElementId(elementid);
				ce.setFirstName(firstName);
				ce.setLastName(lastName);
				ce.setLocation(location);
				ce.setMail(mail);
				ce.setPhonenumber(phonenumber);
				ce.setBrand(brand);
				ce.setType(type);
				ce.setFuel(fuel);
				ce.setDescription(description);
				ce.setPrice(price);
				ce.setBase64image(base64Image);
				ce.setCreated_at(created_at);
				
			// Checken wielange das Element schon vorhanden ist.
				ce.setRestDays(CarDAO.checkrestDays(created_at));
				cars.add(ce);
			}

		} catch (SQLException | IOException ex) {
			ex.printStackTrace();
			throw ex;
		}

		return cars;
	}
	public static ArrayList<CarElement> checkandreadfromDatabase() throws Exception {
 //Checken
		ArrayList<CarElement> cars = new ArrayList<>();
		cars = readfromDatabase();
		for (CarElement c : cars) {
			if(c.getRestDays()<=0) {
				CarDAO.deletecar(c.getElementId());
			}
		}
		cars = readfromDatabase();
		
		
		
		return cars;
	}
}