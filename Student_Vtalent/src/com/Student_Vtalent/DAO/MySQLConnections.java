package com.Student_Vtalent.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnections {
	private static MySQLConnections mysqlconnection = new MySQLConnections();
	Connection connection;

	private MySQLConnections() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/venkatesh", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getInstance() {
		return mysqlconnection.connection;
		
	}
	public static void main(String[] args) {
		System.out.println(MySQLConnections.getInstance());
	}

}
