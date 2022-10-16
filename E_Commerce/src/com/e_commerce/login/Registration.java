package com.e_commerce.login;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;

public class Registration {
	String firstName;
	String lastName;
	String emailId;
	String password;

	public void get_Registration() {
		try {
			Register register = new Register();
			BufferedReader input1 = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("Enter First Name : ");
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
			
			System.out.println(register);

			final String query = "insert into registration values (?,?,?,?)";

			Database_Connection dc = new Database_Connection();
			PreparedStatement ps = dc.connection.prepareStatement(query);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, emailId);
			ps.setString(4, password);

			int i = ps.executeUpdate();
			System.out.println(i + " Registration is complete");
			
			dc.connection.close();
			ps.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
