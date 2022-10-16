package com.e_commerce.login;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {

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

			Database_Connection dc = new Database_Connection();
			PreparedStatement ps = dc.connection.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("Successfully logged in");
				System.out.println("Welcome to online shopping store");
			} else {
				System.err.println("Please Enter Correct Username/Email Id and Password...");
			}

			dc.connection.close();
			ps.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void check_RegisteredList() {
		System.out.println("All the registered user's are below :-");
	}

	public void forgot_password() {
		try {
			BufferedReader input3 = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Please Enter Username/Email Id :");
			String username = input3.readLine();

			final String query = "select Password from registration where Email_Id= ?";

			Database_Connection dc = new Database_Connection();
			PreparedStatement ps = dc.connection.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
					System.out.println("Password is : " + rs.getString("Password"));
			} else {
				System.err.println("Please Enter Correct Username/Email Id");
				forgot_password();
				
			}

//			dc.connection.close();
//			ps.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
