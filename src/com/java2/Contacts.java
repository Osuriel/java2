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
        Contact contact = getContactByName(oldName);
        if (contact != null){
                contact.setName(newName);
                System.out.println("Contact name successfully changed to: " + newName);
        }
    }

    public void modifyContactNumber(String name, String newNumber){
        Contact contact = getContactByName(name);
        if (contact != null){
            contact.setNumber(newNumber);
            System.out.println("Contact: " + name + " number successfully changed to: " + newNumber);
        }
    }

    public void removeContact(String name){
        Contact contact = getContactByName(name);
        if (contact != null){
            contactList.remove(contact);
            System.out.println("Contact: " + name + " was successfully deleted");
        }
    }

    public Boolean contactExit(String name){
        return getContactByName(name) != null;
    }

    public void findContact(String name){
        Contact contact = getContactByName(name);
        if (contact != null){
            System.out.println("Contact: " + contact.getName() + " | Phone #: " + contact.getNumber());
        }
    }

    private Contact getContactByName(String name){
        for(Contact contact : contactList){
            if(name.equalsIgnoreCase(contact.getName())){
                return contact;
            }
        }
        System.out.println("Contact " + name + " not found!");
        return null;
    }

}
