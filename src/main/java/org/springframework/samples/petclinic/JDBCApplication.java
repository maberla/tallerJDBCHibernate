package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCApplication {

	public static void main(String[] args) {
		System.out.println("-------- Test de conexión con MySQL ------------");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentro el driver en el Classpath");
			e.printStackTrace();
			return;
		}

		System.out.println("Driver instalado y funcionando");
		Connection connection = null;
		Statement statement = null;
		
		 
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic","root", "root");
			if (connection != null)
				System.out.println("Conexión establecida");
			String sql = "SELECT * FROM owners";
			try {
				statement = connection.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			ResultSet rs = null;
			try {
				rs = statement.executeQuery(sql);
				while (rs.next()) {
				    System.out.println (rs.getString("id"));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			rs.close();
			//insert
			//statement.executeUpdate("INSERT INTO owners " + "VALUES (11, 'Manuel', 'bermudo.', 'Boston', 'fefe', '65866666')");
		    
			//statement.executeUpdate("UPDATE owners SET city=Sevilla WHERE first_name=Manuel");
			
			String sql2 = "SELECT * FROM owners WHERE first_name LIKE 'Manuel'";
			
			try {
				ResultSet rs2 = statement.executeQuery(sql2);
				while (rs2.next()) {
				    System.out.println (rs2.getString("first_name"));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(statement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}
		
		
		
	}
			 
			
		   
			
	

}
