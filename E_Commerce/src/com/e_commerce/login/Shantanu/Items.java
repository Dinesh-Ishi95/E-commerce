package com.e_commerce.login;
import java.io.*;
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
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
			while (true) {
				ItemList.add((Items) in.readObject());
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
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
