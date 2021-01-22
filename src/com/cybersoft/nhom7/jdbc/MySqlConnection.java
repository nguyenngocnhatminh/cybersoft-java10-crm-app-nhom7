package com.cybersoft.nhom7.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	private static String url = "jdbc:mysql://localhost:3306/CRM_APP";
	private static String username = "root";
	private static String password = "1234";
	
	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			System.out.print("Khong doc duoc driver jdbc");
		}
		catch (SQLException e) {
			System.out.println("Loi ket noi database, vui long kiem tra username va password");
		}
		return null;
	}
}
