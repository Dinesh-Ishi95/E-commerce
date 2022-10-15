package com.e_commerce.miniproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Registration {

	String firstName;
	String lastName;
	String emailId;
	String password;

	public void register() {

		Register register = new Register();

		BufferedReader input1 = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter First Name : ");
		try {
			firstName = input1.readLine();

			register.setFirst_Name(firstName);

			System.out.print("Enter Last Name : ");
			lastName = input1.readLine();
			register.setLast_Name(lastName);

			System.out.print("Enter Email Id : ");
			emailId = input1.readLine();
			register.setEmail_Id(emailId);

			System.out.print("Enter Password : ");
			password = input1.readLine();
			register.setPassword(password);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(register);
	}

	final String Driver = "com.mysql.cj.jdbc.Driver";
	final String URL = "jdbc:mysql://localhost:3306/e_com_project";
	final String userId = "root";
	final String pass = "Dinesh@mysql1995";
	final String query = "insert into registration values (?,?,?,?)";

	public void get_Registration() {

		register();

		try {
			Class.forName(Driver);
			Connection connection = DriverManager.getConnection(URL, userId, pass);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, emailId);
			ps.setString(4, password);

			int i = ps.executeUpdate();
			System.out.println(i + " Registration is complete");

			connection.close();
			ps.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
