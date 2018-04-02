package com.java2;

import com.java2.models.Contact;
import java.util.ArrayList;

public class Contacts {

    private ArrayList<Contact> contactList = new ArrayList<>();

    public void storeContact(String name, String number){
        contactList.add(new Contact(name, number));
        System.out.println(name + " was successfully added to your contacts.");
    }

    public void modifyContactName(String oldName, String newName){
//        int position = contactList.indexOf(oldName);
//        if(position > -1){
//            contactList.get(position).setName(newName);
//            System.out.println("Contact name successfully changed to: " + newName);
//        }
//        System.out.println("Contact" + oldName + " not found!");

        //////

//        contactList.forEach((contact) -> {
//            if (oldName.equals(contact.getName())){
//                contact.setName(newName);
//                System.out.println("Contact name successfully changed to: " + newName);
//            }
//        });

        for(Contact contact : contactList){
            if (oldName.equalsIgnoreCase(contact.getName())){
                contact.setName(newName);
                System.out.println("Contact name successfully changed to: " + newName);
                break;
            } else if (contactList.indexOf(contact) == contactList.size() -1){
                System.out.println("Contact" + oldName + " not found!");
            }
        }
    }

    public void modifyContactNumber(String name, String newNumber){
        int position = contactList.indexOf(name);
        if (position > -1){
            contactList.get(position).setNumber(newNumber);
            System.out.println("Contact: " + name + " number successfully changed to: " + newNumber);
        }
        System.out.println("Contact" + name + " not found!");
    }

    public void removeContact(String name){
        int position = contactList.indexOf(name);
        if (position > -1){
            contactList.remove(position);
            System.out.println("Contact: " + name + "was successfully deleted");
        }
        System.out.println("Contact" + name + " not found!");
    }

    public Boolean contactExit(String name){
        Boolean exist = false;
        for(Contact contact : contactList){
            if(name.equalsIgnoreCase(contact.getName())){
                exist = true;
                break;
            }
        }
        return exist;
    }

    public void findContact(String name){
        for(Contact contact : contactList){
            if(name.equalsIgnoreCase(contact.getName())){
                System.out.println("Contact: " + contact.getName() + " | Phone #: " + contact.getNumber());
            } else if (contactList.indexOf(contact) == contactList.size() -1){
                System.out.println("Contact " + name + " not found!");
            }
        }
    }

    private Contact getContactByName(String name){
        for(Contact contact : contactList){
            if(name.equalsIgnoreCase(contact.getName())){
                return contact;
            }
        }
        return null;
    }

}
