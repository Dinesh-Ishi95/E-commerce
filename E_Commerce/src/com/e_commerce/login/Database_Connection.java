package com.e_commerce.login;

import java.sql.Connection;
import java.sql.DriverManager;

public final class Database_Connection {
	final String Driver = "com.mysql.cj.jdbc.Driver";
	final String URL = "jdbc:mysql://localhost:3306/e_com_project";
	final String userId = "root";
	final String pass = "Dinesh@mysql1995";
	Connection connection;

	public Database_Connection() throws Exception {
		Class.forName(Driver);
		connection = DriverManager.getConnection(URL, userId, pass);
	}
}
