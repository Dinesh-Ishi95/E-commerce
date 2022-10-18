package com.e_commerce.login;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Admin {

	public void admin_Login() {
		try {
			String username;
			String password;

			System.out.println("Please sign in...");
			BufferedReader input2 = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("Enter Username : ");
			username = input2.readLine();

			System.out.print("Enter Password : ");
			password = input2.readLine();

			final String query = "select Admin_Username, Admin_Password from admin where Admin_Username= ? and Admin_Password= ?";

			Database_Connection dc = new Database_Connection();
			PreparedStatement ps = dc.connection.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("Successfully logged in");
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
		try {
			final String query = "select * from registration";
			System.out.println("All the registered user's are below :-");
			System.out.println();
			Database_Connection dc = new Database_Connection();
			Statement s = dc.connection.createStatement();
			ResultSet rs = s.executeQuery(query);

			System.out.printf("%-15s %-15s %-25s %-50s %n", "First_Name", "Last_Name", "Email_Id", "Password");
			/*
			 * In printf() statement every digit denotes something 
			 * 1) First %-15s allocates 15 spaces for 1st column and - indicates left alignment 
			 * 2) Second %-15s allocates 15 spaces for 2nd column and - indicates left alignment 
			 * 3) Third %-25s allocates 25 spaces for 3rd column and - indicates left alignment 
			 * 4) Fourth %-50s allocates 50 spaces for 4th column and - indicates left alignment 
			 * 5) fifth %n indicate insert to new line
			 */
			while (rs.next()) {
				System.out.printf("%-15s %-15s %-25s %-50s %n", rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void get_ProductQuantity() {

		try {
			get_ProductList();
			Database_Connection dc = new Database_Connection();
			System.out.println("---------------------------------");
			System.out.println();
			BufferedReader input4 = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Please Enter Product_Id : ");
			String product_Id = input4.readLine();
			
			final String query2 = "select Product_Qty, Product_Name from products where Product_Id=?";

			PreparedStatement ps = dc.connection.prepareStatement(query2);
			ps.setString(1, product_Id);
			ResultSet rs2 = ps.executeQuery();

			if (rs2.next()) {
				System.out.println("Total Qty of "+rs2.getString("Product_Name")+" is : "+rs2.getString("Product_Qty"));
			} else {
				System.err.println("Please Enter Correct Product_Id");
				System.out.println("---------------------------------");
				System.out.println();
				get_ProductQuantity();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
	
	public void get_ProductList() {
		
		try {
			final String query1 = "select * from products";
			System.out.println("All the avilable Products are below :-");
			System.out.println();
			Database_Connection dc = new Database_Connection();
			Statement s1 = dc.connection.createStatement();
			ResultSet rs1 = s1.executeQuery(query1);

			System.out.printf("%-15s %-15s %n", "Product_Id", "Product_Name");
			System.out.println("---------------------------------");

			while (rs1.next()) {
				System.out.printf("%-15s %-15s %n", rs1.getString(1), rs1.getString(2));
			}
			System.out.println("---------------------------------");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
	}

	public static void main(String[] args) {

		Admin admin = new Admin();
		admin.admin_Login();
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Registered User\n2. Product Quantity");
		int choice = sc.nextInt();
		if (choice == 1) {
			admin.check_RegisteredList();
		} else if (choice == 2) {
			admin.get_ProductQuantity();
		}
	}
}
