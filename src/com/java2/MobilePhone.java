package com.java2;

import java.util.Scanner;

public class MobilePhone {

    private static Contacts contacts = new Contacts();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String [] args){
        Boolean quit = false;
        printMenu();
        while (!quit){
            System.out.println("Make a selection. For the menu enter: 0 ");
            int input = scanner.nextInt();
            scanner.nextLine();

            switch(input){
                case 0:
                    printMenu();
                    break;

                case 1:
                    createContact();
                    break;

                case 2:
                    modifyContact();
                    break;

                case 3:
                    removeContact();

                case 4:
                    findContact();
                    break;

                case 5:
                    quit = true;
                    break;
            }



        }
    }

    private static void printMenu(){
        System.out.println("Menu / Please enter one of the following numbers to make a selection.");
        System.out.println("0: Print Menu  |  1: Create contact  |  2: Modify contact  |  3: Remove contact  |  4: Find contact  |  5: Quit");
    }

    private static void createContact(){
        System.out.println("--Create new contact--");
        System.out.println("Please Enter a Name:");
        String name = scanner.nextLine();
        System.out.println("Please Enter Phone number:");
        String number = scanner.nextLine();
        contacts.storeContact(name, number);
    }

    private static void modifyContact(){
        System.out.println("--Modify contact--");
        System.out.println("Please the name of the contact you wish to modify:");
        String oldName = scanner.nextLine();

        if(contacts.contactExit(oldName)){
            System.out.println("Press:");
            System.out.println("1: Change contact name  |  2: Change number | 3: cancel and go back to main menu");
            int nameOrNumber = scanner.nextInt();
            scanner.nextLine();
            if (nameOrNumber == 1){
                System.out.println("Enter new name:");
                String newName = scanner.nextLine();
                contacts.modifyContactName(oldName, newName);
            } else if (nameOrNumber == 2){
                System.out.println("Enter new phone number");
                String newNumber = scanner.nextLine();
                contacts.modifyContactNumber(oldName, newNumber);
            } else if (nameOrNumber != 3) {
                System.out.println("Invalid input, please select");
                System.out.println("1: Change contact name  |  2: Change number | 3: cancel and go back to main menu");
            }
        } else {
            System.out.println("Contact does not exist");
        }
    }

    private static void removeContact(){
        System.out.println("Enter name of the contact you want to remove:");
        String name = scanner.nextLine();
        contacts.removeContact(name);
    }

    private static void findContact(){
        System.out.println("Enter name of contact you want to find:");
        String name = scanner.nextLine();
        contacts.findContact(name);
    }
}
