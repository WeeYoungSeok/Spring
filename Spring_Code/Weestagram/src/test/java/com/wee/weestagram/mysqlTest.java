package com.wee.weestagram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class mysqlTest {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3305/mysql?serverTimezone=UTC";
	private static final String username = "root";
	private static final String password = "admin1234";
	
	
	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL,username,password);
			System.out.println("Success");
			System.out.println(con);
		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
	
}
