package com.e_commerce.login;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

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
