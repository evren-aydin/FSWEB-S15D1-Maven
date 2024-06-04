package org.example;

import org.example.mobile.Contact;
import org.example.mobile.MobilePhone;
import org.example.models.Grocery;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Contact> contacts = new ArrayList<>();

        contacts.add(new Contact("Bob","31415926"));
        contacts.add(new Contact("Alice","16180339"));
        contacts.add(new Contact("Tom","11235813"));
        contacts.add(new Contact("Jane","23571113"));
        MobilePhone myPhone = new MobilePhone("123456", contacts);

        myPhone.printContact();

    }
}
