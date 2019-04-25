//made by Jeremiah
//p.s. I can't get compareTo() to work for isle numbers

import java.util.*;
import java.io.*;

public class ShoppingList {
	ArrayList<Item> itemList = new ArrayList<Item>();

	public static void main(String[] args) {
		new ShoppingList().go();
	}

	class ItemName implements Comparator<Item> {
		public int compare(Item one, Item two) {
			return one.compareTo(two);
		}
	}

	public void go() {
		getItems();
		System.out.println(itemList);
		Collections.sort(itemList);
		System.out.println(itemList);

		ItemName itemName = new ItemName();
		Collections.sort(itemList, itemName);

		System.out.println(itemList);
	}

	void getItems() {
		try {
			File file = new File("ItemListMore.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				addItem(line);
			}
		} catch (Exception ex) {
			try {
				Formatter x = new Formatter("ItemListMore.txt");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			};
		}
	}

	void addItem(String lineToParse) {
		String[] tokens = lineToParse.split("/");
		Item nextItem = new Item(Integer.parseInt(tokens[0]), Double.parseDouble(tokens[1]), tokens[2]);
		itemList.add(nextItem);
	}
}


class Item implements Comparable<Item> {
	int isleNumber;
	double price;
	String itemName;

	public Item(int in, double p, String n) {
		isleNumber = in;
		price = p;
		itemName = n;
	}

	public boolean equals(Object aItem) {
		Item s = (Item) aItem;
		return getItemName().equals(s.getItemName());
	}

	public int hashCode() {
		return itemName.hashCode();
	}

	public int compareTo(Item s) {
		return itemName.compareTo(s.getItemName());
	}

	public double getPrice() {
		return price;
	}

	public String getItemName() {
		return itemName;
	}

	public int getIsleNumber() {
		return isleNumber;
	}

	public String toString() {
	