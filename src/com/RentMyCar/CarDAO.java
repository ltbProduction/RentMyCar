package com.RentMyCar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.concurrent.TimeUnit;
 
public class CarDAO {
	private static String databaseURL = "jdbc:mysql://localhost:3306/rentmycar?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
	private static String user = "root";
	private static String password = "RentMyCar2019";
    // Methode welches ein Element ausliest und es als Element zurückgibt. Element ID muss bekannt sein.
	
    public CarElement get(int id) throws SQLException, IOException {
        CarElement car = null;
         
        String sql = "SELECT * FROM carelement WHERE element_id = ?";
         
        try (Connection connection = DriverManager.getConnection(databaseURL, user, password)) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
             
            if (result.next()) {
                car = new CarElement();
                String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				String location = result.getString("location");
				String mail = result.getString("email");
				String phonenumber = result.getString("phonenumber");
				String brand = result.getString("carbrand");
				String type = result.getString("cartyp");
				String fuel = result.getString("fueltyp");
				String description = result.getString("description_text");
				Double price = result.getDouble("price");
				Blob blob = result.getBlob("photo");
				Date created_at = result.getDate("created_at");
                 
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

				car.setFirstName(firstName);
				car.setLastName(lastName);
				car.setLocation(location);
				car.setMail(mail);
				car.setPhonenumber(phonenumber);
				car.setBrand(brand);
				car.setType(type);
				car.setFuel(fuel);
				car.setDescription(description);
				car.setPrice(price);
				car.setBase64image(base64Image);
				car.setCreated_at(created_at);
            }          
             
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
            throw ex;
        }      
         
        return car;
    }
    
    //Methode welches ein Element löscht. Wird bei der Prüfung verwendet.
    public static void deletecar(int elementid) throws Exception {
    	String sql = "DELETE FROM carelement WHERE element_id = " + String.valueOf(elementid);
        try (Connection connection = DriverManager.getConnection(databaseURL, user, password)) {
        	PreparedStatement statement = connection.prepareStatement(sql);
        	statement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
           
            throw ex;
        }
    }
    //Die restlichen tage werden gecheckt wielange dieses CarElement online ist.
	public static long checkrestDays(java.sql.Date d1) {
		
		java.util.Date d2 = new java.util.Date();
		java.util.Date d3 = (java.util.Date) d1;
	    long diff = d2.getTime() - d3.getTime();
	    long time = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	    return 30-time;
	}
}