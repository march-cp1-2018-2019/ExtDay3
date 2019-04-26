package com.hf.chap16;

import java.util.*;
import java.io.*;

public class ShoppingList{
  ArrayList<Item> shoppingList = new ArrayList<Item>();

  public static void main(String[] args){
    new ShoppingList().go();
  }

  class ItemCompare implements Comparator<Item>{
    public int compare(Item one, Item two){
      return one.getItem().compareTo(two.getItem());
    }
  }

  public void go(){
    getItems();
    System.out.println(shoppingList);
    Collections.sort(shoppingList);
    System.out.println(shoppingList);

    ItemCompare itemCompare = new ItemCompare();
    Collections.sort(shoppingList, itemCompare);

    System.out.println(shoppingList);
  }

  void getItems(){
    try{
      File file = new File("ShoppingList.txt");
      BufferedReader reader = new BufferedReader(new FileReader(file));
      
      String line = null;
      while((line = reader.readLine()) != null){
        addItem(line);
      }
      
      reader.close();
    }catch(Exception ex){
      ex.printStackTrace();
    }
  }

  void addItem(String lineToParse){
    String[] tokens = lineToParse.split("/");
    
    String item = tokens[0];
    int isle = Integer.parseInt(tokens[1]);
    double price = Double.parseDouble(tokens[2]);
    
    Item nextItem = new Item(item, isle, price);
    shoppingList.add(nextItem);
  }
}
