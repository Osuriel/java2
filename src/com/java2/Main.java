package com.java2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static GroceryList groceryList = new GroceryList();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here
        boolean quit = false;
        while (!quit) {
            printChoices();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printChoices();
                    break;
                case 1:
                    printGroceryList();
                    break;
                case 2:
                    addItemToLeast();
                    break;
                case 3:
                    modifyItemInList();
                    break;
                case 4:
                    removeItemFromList();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
                case 7:
                    processArrayList();
                    break;
            }
        }
        System.out.println("Thank you for using this very stupid app!");

    }

    private static void printChoices() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Menu | Please Press:");
        System.out.print("0- To print choice options.  ");
        System.out.print("1- To print the list of grocery items.  ");
        System.out.print("2- To add an item in the list.  ");
        System.out.print("3- To modify an item in the list.  ");
        System.out.print("4- To remove an item from the list.  ");
        System.out.print("5- To search for an item in the list.  ");
        System.out.print("6- To quit the application.  ");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    private static void printGroceryList() {
        groceryList.printGroceryList();
    }

    private static void

    addItemToLeast() {
        boolean quit = false;
        while (!quit) {
            System.out.println("Please enter the name of the item to add to the list");
            String inputItem = scanner.nextLine();
            groceryList.addGroceryItem(inputItem);
            System.out.println("You successfully added " + inputItem + " to the shopping list");
            System.out.println("--- Do you wish to add more items to your shopping list [Y/N] ---");
            quit = scanner.nextLine().equalsIgnoreCase("N");
        }
    }

    private static void modifyItemInList() {
        System.out.println("Please enter the name of the item to remove from the list");
        String currentItem = scanner.nextLine();
        System.out.println("Enter the name of the new item for this item");
        String newName = scanner.nextLine();
        groceryList.modifyGroceryItem(currentItem, newName);
        System.out.println("Item successfully modified!");
    }

    private static void removeItemFromList() {
        System.out.println("Please enter the name of the item to remove from the list");
        String input = scanner.nextLine();
        groceryList.removeGroceryItem(input);
        System.out.println("The item was successfully removed from the list");
    }

    private static void searchForItem() {
        System.out.println("Please enter the name of the item to search");
        String input = scanner.nextLine();

        if(groceryList.onFile(input)){
            System.out.println("Found " + input);
        } else {
            System.out.println(input + " is not on file." +
                    " ");
        }
    }

    public static void processArrayList(){
        ArrayList<String> newList = new ArrayList<String>();
        newList.addAll(groceryList.getGroceryList());

        ArrayList<String> nextList = new ArrayList<String>(groceryList.getGroceryList());

        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);

        System.out.println("Print newList");
        for (String item : newList){
            System.out.println(item);
        }


        System.out.println("Print nextList ");
        for (String item : nextList){
            System.out.println(item);
        }

        System.out.println("Print myArray:");
        for (String item : myArray){
            System.out.println(item);
        }
    }
}
