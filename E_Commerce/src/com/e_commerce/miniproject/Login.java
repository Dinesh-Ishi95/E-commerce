package com.e_commerce.miniproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {

	final String Driver = "com.mysql.cj.jdbc.Driver";
	final String URL = "jdbc:mysql://localhost:3306/e_com_project";
	final String userId = "root";
	final String pass = "Dinesh@mysql1995";

	public void sign_In() {

		try {
			String username;
			String password;

			System.out.println("Please sign in...");
			BufferedReader input2 = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter Username : ");
			username = input2.readLine();
			System.out.print("Enter Password : ");
			password = input2.readLine();

			final String query = "select Email_Id,Password from registration where Email_Id= ? and Password= ?";

			Class.forName(Driver);
			Connection connection = DriverManager.getConnection(URL, userId, pass);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				System.out.println("Successfully logged in");
				System.out.println("Welcome to online shopping store");
			} else {
				System.out.println("Please enter correct username and password");
			}

			input2.close();
			connection.close();
			ps.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void forgot_password() {
		try {
			BufferedReader input3 = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Please enter username :");
			String username = input3.readLine();
			final String query = "select Password from registration where Email_Id= ?";

			Class.forName(Driver);
			Connection connection = DriverManager.getConnection(URL, userId, pass);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("Password is : " + rs.getString("Password"));
			}

			input3.close();
			connection.close();
			ps.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
