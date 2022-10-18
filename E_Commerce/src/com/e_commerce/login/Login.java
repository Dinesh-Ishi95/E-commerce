package com.e_commerce.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

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
			
			ShoppingCart sc = new ShoppingCart();
			
			try {
				Items i = null;
				sc.AddToCart(i);
				sc.TotalPrice();
				sc.PrintInvoice();
//				sc.RemoveItem();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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

	public static void main(Object object) {
		// TODO Auto-generated method stub
		Registration registration = new Registration();
		Login login = new Login();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Welocome to online shopping store...");
		System.out.println("1. New User : Sign Up");
		System.out.println("2. Old User : Sign In");
		System.out.println("3. Forgot Password");
		System.out.println();
		System.out.println("Please select option : ");
		int input = scanner.nextInt();
		
		if (input == 1) {
			registration.get_Registration();
			System.out.println();
			login.sign_In();
		} else if (input == 2) {
			login.sign_In();
		} else if (input == 3) {
			login.forgot_password();
			System.out.println();
			login.sign_In();
		}
		scanner.close();
	}
}
