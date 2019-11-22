package com.RentMyCar;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class DatabaseConnection {
	 public static void main(String[] args) throws ClassNotFoundException {
		 CarElement c1 = new CarElement("Linus Brugger", "Ravensburg", "linus@brugger-rv.de", "01709123866", "Audi", "A4", "Diesel", "Tolles Auto", 1.3);
		

			
			 writeToDatabase(c1);
	 }
	
	public static void writeToDatabase(CarElement c1) throws ClassNotFoundException {
		try {
			//Class.forName("com.mysql.jdbc");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentmycar?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin", "root", "RentMyCar2019");
			Statement statement = conn.createStatement();
			String datac1;
			datac1 = "'"+c1.getName()+"',";
			datac1 = datac1 + "'"+c1.getMail()+"',";
			datac1 = datac1 + "'"+c1.getPhonenumber()+"',";
			datac1 = datac1 + "'"+c1.getBrand()+"',";
			datac1 = datac1 + "'"+c1.getType()+"',";
			datac1 = datac1 + "'"+c1.getFuel()+"',";
			datac1 = datac1 + "'"+String.valueOf(c1.getPrice())+"',";
			datac1 = datac1 + "'"+c1.getDescription()+"'";
			
			String insert = "insert into carelement(persName, email, phonenumber, carbrand, cartyp, fueltyp, price, description_text) values ("+datac1+")";
			
			statement.executeUpdate(insert);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

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
	  

