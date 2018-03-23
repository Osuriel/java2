package com.java2;

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
            }
        }
        System.out.println("Thank you for using this very stupid app!");
    }

    private static void modifyItemInList() {
        System.out.println("Please enter the list number of the item to remove from the list");
        int position = scanner.nextInt();
        System.out.println("Enter the name of the new name for this item");
        String newName = scanner.next();
        groceryList.modifyGroceryItem(position - 1, newName);
        System.out.println("Item successfully modified!");
    }

    private static void printChoices() {
        System.out.println("Menu | Please Press:");
        System.out.println("0 - To print choice options.");
        System.out.println("1 - To print the list of grocery items.");
        System.out.println("2 - To add an item in the list");
        System.out.println("3 - To modify an item in the list.");
        System.out.println("4 - To remove an item from the list.");
        System.out.println("5 - To search for an item in the list.");
        System.out.println("6 - To quit the application.");
    }

    private static void printGroceryList() {
        groceryList.printGroceryList();
    }

    private static void addItemToLeast() {
        boolean quit = false;
        while (!quit) {
            System.out.println("Please enter the name of the item to add to the list");
            String inputItem = scanner.next();
            groceryList.addGroceryItem(inputItem);
            System.out.println("You successfully added " + inputItem + " to the shopping list");
            System.out.println("--- Do you wish to add more items to your shopping list [Y/N] ---");
            quit = scanner.next().equalsIgnoreCase("N");
        }
    }

    private static void removeItemFromList() {
        System.out.println("Please enter the list number of the item to remove from the list");
        int input = scanner.nextInt();
        groceryList.removeGroceryItem(input - 1);
        System.out.println("The item was successfully removed from the list");
    }

    private static void searchForItem() {
        System.out.println("Please enter the name of the item to search");
        String input = scanner.next();
        groceryList.findItem(input);
    }
}