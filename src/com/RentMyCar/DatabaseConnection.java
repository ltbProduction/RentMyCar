package com.RentMyCar;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.ForEach;



public class DatabaseConnection {
	private static String url = "jdbc:mysql://localhost:3306/rentmycar?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
	 
	//Ab Hier ignorieren
	public static void main(String[] args) throws ClassNotFoundException {
		 CarElement c1 = new CarElement("Linus Brugger", "Ravensburg", "linus@brugger-rv.de", "01709123866", "Audi", "A4", "Diesel", "Tolles Auto", 1.3);
		 CarElement c2 = new CarElement("Robin Birkhofer", "Ravensburg", "was", "01709123866", "Renault", "Twingo", "Benzin", "Scheiﬂ Auto", -3);


			
			 writeToDatabase(c1);
			 writeToDatabase(c2);
		ArrayList<CarElement> cars = new ArrayList<>();
		cars = readfromDatabase();
		
		for(CarElement c : cars){
			System.out.println(c.getFuel());
			System.out.println(c.getName());
		}
			
		}
	//Bis hier
	 
	
	public static void writeToDatabase(CarElement c1) throws ClassNotFoundException {
		try {
			//Class.forName("com.mysql.jdbc");
			Connection conn = DriverManager.getConnection(url, "root", "RentMyCar2019");
			Statement statement = conn.createStatement();
			String datac1;
			datac1 = "'"+c1.getName()+"',";
			datac1 = datac1 + "'"+c1.getOrt()+"',";
			datac1 = datac1 + "'"+c1.getMail()+"',";			
			datac1 = datac1 + "'"+c1.getPhonenumber()+"',";
			datac1 = datac1 + "'"+c1.getBrand()+"',";
			datac1 = datac1 + "'"+c1.getType()+"',";
			datac1 = datac1 + "'"+c1.getFuel()+"',";
			datac1 = datac1 + "'"+String.valueOf(c1.getPrice())+"',";
			datac1 = datac1 + "'"+c1.getDescription()+"'";
			
			String insert = "insert into carelement(persName, location, email, phonenumber, carbrand, cartyp, fueltyp, price, description_text) values ("+datac1+")";
			
			statement.executeUpdate(insert);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<CarElement> readfromDatabase(){
		ArrayList<CarElement> cars = new ArrayList<CarElement>();
		 try
		    {
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
		      while (rs.next())
		      {
		    	 
		      
		    	CarElement ce = new CarElement(rs.getString("persName"),
								rs.getString("location"), 
								rs.getString("email"), 
								rs.getString("phonenumber"), 
								rs.getString("carbrand"), 
								rs.getString("cartyp"), 
								rs.getString("fueltyp"),
								rs.getString("description_text"),
								rs.getDouble("price"));
								
		    	ce.setCreated_at(rs.getDate("created_at"));
		        cars.add(ce);
		    	 
		        
		      }
		      st.close();
		    }
		    catch (Exception e)
		    {
	

	}
			return cars;
	  
	}

	
	


}