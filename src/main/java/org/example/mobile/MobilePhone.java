package org.example.mobile;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    // Constructor
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;

    }

    // Getter for myNumber
    public String getMyNumber() {
        return myNumber;
    }

    // Getter for myContacts
    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    // Add new contact
    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            return false; // Contact already exists
        }
        myContacts.add(contact);
        return true;
    }

    // Update contact
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            return false; // Old contact not found
        }
        if (findContact(newContact.getName()) != -1) {
            return false; // New contact with the same name already exists
        }
        myContacts.set(foundPosition, newContact);
        return true;
    }

    // Remove contact
    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            return false; // Contact not found
        }
        myContacts.remove(foundPosition);
        return true;
    }

    // Find contact by Contact object
    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    // Find contact by name
    private int findContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1; // Not found
    }

    // Query contact by name
    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.myContacts.get(position);
        }
        return null; // Not found
    }

    // Print all contacts
    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}
