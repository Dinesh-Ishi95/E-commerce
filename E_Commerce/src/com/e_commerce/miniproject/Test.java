package com.e_commerce.miniproject;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Registration registration = new Registration();
		Login login = new Login();

		Scanner scanner = new Scanner(System.in);
		System.out.println("1. New User : Sign Up");
		System.out.println("2. Old User : Sign In");
		System.out.println("3. Forgot Password");
		System.out.println("Please select option : ");
		int input = scanner.nextInt();
		System.out.println(input);
		if (input == 1) {
			registration.get_Registration();
			login.sign_In();
		} else if (input == 2) {
			login.sign_In();
		} else if (input == 3) {
			login.forgot_password();
		}
		scanner.close();
	}
}
