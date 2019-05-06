import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class shoppingLIst {
	ArrayList<Item> itemList = new ArrayList<Item>();

	public static void main(String[] args) {
		new shoppingLIst().go();

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
			File file = new File("ItemList.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				addItem(line);
			}	
		}
	}

	void addItem(String lineToParse) {
		String[] tokens = lineToParse.split("/");
		Item nextItem = new Item(Integer.parseInt(tokens[0]), Double.parseDouble(tokens[1]), tokens[2]);
		itemList.add(nextItem);
	}
}


class Item implements Comparable<Item> {
	int num;
	double price;
	String itName;

	public Item(int in, double p, String n) {
		num = in;
		price = p;
		itName = n;
	}


	public boolean equals(Object aItem) {
		Item s = (Item) aItem;
		return getItemName().equals(s.getItemName());
	}

	public int compareTo(Item s) {
		return itName.compareTo(s.getItemName());
	}


	public double getPrice() {
		return price;
	}

	public String getItemName() {
		return itName;
	}

	public int getIsTheNumber() {
		return num;
	}

