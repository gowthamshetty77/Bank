package com.bank.connectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionFactory {
	
	public static Connection requestConnection() {
		
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/bank";
		String user = "root";
		String password = "Ravana2525";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
