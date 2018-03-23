package com.java2;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList= new ArrayList<String>();

    public void addGroceryItem(String item){
        groceryList.add(item);
    }

    public void printGroceryList(){
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        for(String item : groceryList){
            int position = groceryList.indexOf(item);
            System.out.println( (position + 1) + " " + item);
        }
    }

    public void modifyGroceryItem(int position, String newItem){
        groceryList.set(position, newItem);
        System.out.println("Grocery item " + (position + 1) + " has been modified");
    }

    public void removeGroceryItem(int position) {
        String theItem = groceryList.get(position - 1);
        groceryList.remove(position - 1);
        System.out.println("You have removed " + theItem);
    }

    public String findItem(String searchItem){
        // boolean exist = groceryList.contains(searchItem);
        int position = groceryList.indexOf(searchItem);
        if(position >= 0) {
            return groceryList.get(position);
        }
        return null;
    }
}
