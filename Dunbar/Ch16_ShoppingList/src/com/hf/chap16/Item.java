package com.hf.chap16;

public class Item implements Comparable<Item>{
  String item;
  int isle;
  double price;

  public Item(String i, int il, double p){
    item = i;
    isle = il;
    price = p;
  }

  public boolean equals(Object anItem){
    Item s = (Item) anItem;
    return getItem().equals(s.getItem());
  }

  public int hashCode(){
    return item.hashCode();
  }

  public int compareTo(Item i){
    return item.compareTo(i.getItem());
  }

  public String getItem(){
    return item;
  }

  public int getIsle(){
    return isle;
  }

  public double getPrice(){
    return price;
  }

  public String toString(){
    return item;
  }

}
