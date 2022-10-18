package com.e_commerce.login;

import java.io.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Items {
	private String ItemName;
	private int ItemRating;
	private float ItemPrice;

	public static ArrayList<Items> ItemList = new ArrayList<Items>();
	static Scanner in = new Scanner(System.in);

	Items(String ItemName, int ItemRating, float ItemPrice) {
		this.ItemName = ItemName;
		this.ItemRating = ItemRating;
		this.ItemPrice = ItemPrice;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public int getItemRating() {
		return ItemRating;
	}

	public void setItemRating(int itemrating) {
		ItemRating = itemrating;
	}

	public float getItemPrice() {
		return ItemPrice;
	}

	public void setItemPrice(float itemprice) {
		ItemPrice = itemprice;
	}

	public static void main(String[] args) throws IOException {
		try {
			final String query1 = "select * from products";
			System.out.println("All the avilable Products are below :-");
			System.out.println();
			Database_Connection dc = new Database_Connection();
			Statement s1 = dc.connection.createStatement();
			ResultSet rs1 = s1.executeQuery(query1);
			String format = "%-15s %-20s %-20s %-15s %-15s %n";

			System.out.println(
					"================================================================================================================================================");
			System.out.printf(format, "Product_Id", "Product_Name", "Product_Price", "Product_Qty",
					"Product_Discription");
			System.out.println(
					"================================================================================================================================================");

			while (rs1.next()) {
				System.out.printf(format, rs1.getString(1), rs1.getString(2), "Rs." + rs1.getString(3) + ".00/-",
						rs1.getString(4), rs1.getString(5));
				System.out.println(
						"------------------------------------------------------------------------------------------------------------------------------------------------");
			}
//				ObjectInputStream in = new ObjectInputStream(new FileInputStream());
//				while (true) {
//					ItemList.add((Items) in.readObject());
//				}
			}
//		} catch (FileNotFoundException e) {
//			System.out.println("File Not Found");
//		} catch (IOException e) {
		 catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("1.View All Items\n2.View a selected Item");
		int choose = in.nextInt();
		switch (choose) {
		case 1:
			ViewAll(choose);
			break;
		case 2:
			System.out.println("Enter id of item to be viewed");
			int itemid = in.nextInt();
			ViewItem(itemid);
			break;
		default:
			System.out.print("Invalid Choice\n");
		}
	}

	private static void ViewItem(int itemid2) {
		// TODO Auto-generated method stub

	}

	private static void ViewAll(int choose) {
		// TODO Auto-generated method stub

	}
}
