package com.e_commerce.login;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
			System.out.println(	);
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
				System.out.printf("%-15s %-15s %-25s %-50s\n", rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Admin admin = new Admin();
//		admin.admin_Login();
		admin.check_RegisteredList();
	}
}
