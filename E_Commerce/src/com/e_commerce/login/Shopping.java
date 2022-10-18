package com.e_commerce.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Shopping {

	public void inventory() {

		try {
			final String query1 = "select * from products";
			System.out.println("All the avilable Products are below :-");
			System.out.println();
			Database_Connection dc = new Database_Connection();
			Statement s1 = dc.connection.createStatement();
			ResultSet rs1 = s1.executeQuery(query1);
			String format = "%-10s %-15s %-20s %-20s %-15s %-15s %n";

			System.out.println(
					"==========================================================================================================================================================");
			System.out.printf(format, "Sr_No", "Product_Id", "Product_Name", "Product_Price", "Product_Qty",
					"Product_Discription");
			System.out.println(
					"==========================================================================================================================================================");

			while (rs1.next()) {
				System.out.printf(format, rs1.getString(1), rs1.getString(2), rs1.getString(3),
						"Rs." + rs1.getString(4) + ".00/-", rs1.getString(5), rs1.getString(6));
				System.out.println(
						"----------------------------------------------------------------------------------------------------------------------------------------------------------");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public void do_Shopping() {

		try {
			inventory();
			Scanner sc = new Scanner(System.in);
			char choice = '\0';

			do {

				System.out.print("Enter Sr_No : ");
				String Product_SrNo = sc.nextLine();
				System.out.print("Enter Purchase_Qty : ");
				String Purchase_Qty = sc.nextLine();
				int pq = Integer.parseInt(Purchase_Qty);

				final String query = "select Product_Qty from products where Sr_No=? ";

				Database_Connection dc = new Database_Connection();
				PreparedStatement ps = dc.connection.prepareStatement(query);
				ps.setString(1, Product_SrNo);
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					int qty = rs.getInt("Product_Qty");
				}

				int qty = rs.getInt(1);
				int updated_Qty = qty - pq;

				final String query1 = "update products set Product_Qty=? where Product_Name=?";
				PreparedStatement ps1 = dc.connection.prepareStatement(query1);
				ps1.setLong(1, updated_Qty);
				ps1.setString(2, Product_SrNo);
				ps1.executeUpdate();
				System.out.println("Do you want to continue shopping : Y or N");
				choice = sc.next().charAt(0);
				sc.nextLine();

			} while (choice == 'Y' || choice == 'y');

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Please enter Y or N only...."+ e);
		}
	}

	public static void main(String[] args) {
		Shopping s = new Shopping();
		s.do_Shopping();
	}

}
