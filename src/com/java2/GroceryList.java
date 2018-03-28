package com.java2;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList= new ArrayList<String>();

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

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

    public void modifyGroceryItem(String currentItem, String newItem){
        int position = findItem(currentItem);
        if (position >= 0) {
            modifyGroceryItem(position, newItem);
        }
    }

    private void modifyGroceryItem(int position, String newItem){
        groceryList.set(position, newItem);
    }

    public void removeGroceryItem(String item){
        int position = findItem(item);
        if (position >= 0){
            removeGroceryItem(position);
        }
    }

    private void removeGroceryItem(int position) {
        String theItem = groceryList.get(position);
        groceryList.remove(position);
        System.out.println("You have removed " + theItem);
    }

    public int findItem(String searchItem){
        // boolean exist = groceryList.contains(searchItem);
        return groceryList.indexOf(searchItem);
    }

    public boolean onFile(String itemName){
        int position = findItem(itemName);
        if (position >= 0){
            return true;
        }
        return false;
    }
}
