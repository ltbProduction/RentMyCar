package com.RentMyCar;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class DatabaseConnection {
	
	public static void writeToDatabase(String message) throws ClassNotFoundException {
		try {
			//Class.forName("com.mysql.jdbc");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentmycar?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin", "root", "RentMyCar2019");
			Statement statement = conn.createStatement();
			
			String insert = "insert into test(message) values ('" + message + "')";
			
			statement.executeUpdate(insert);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	 public static void main(String[] args) {
//		 try {
//			
//			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/messages?useSSL= false", "root", "RentMyCar2019");
//			 Statement stmt = con.createStatement();
//			 String message = "Test";
//			 String sql = "insert into messages(messages) values ('"+ message + "');";
//			 //ResultSet rs = stmt.executeQuery(sql);
//			 //stmt.execute("use messages;");
//			 stmt.executeUpdate(sql);
//			
//		 } catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("FEHLER");
		}
	 }
	  

