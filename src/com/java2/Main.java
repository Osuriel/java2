package com.java2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	// write your code here
        GroceryList groceryList = new GroceryList();
        groceryList.addGroceryItem("Bread");
        groceryList.addGroceryItem("Bananas");
        groceryList.addGroceryItem("Cake");
        groceryList.printGroceryList();

        groceryList.modifyGroceryItem(0, "Cereal");

        groceryList.printGroceryList();

        groceryList.removeGroceryItem(3);

        groceryList.printGroceryList();


    }
}
