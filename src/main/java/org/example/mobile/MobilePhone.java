package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
private String myNumber;
private List<Contact> myContacts;

    public MobilePhone(String myNumber, List<Contact> contacts) {
        this.myNumber = myNumber;
        this.myContacts = contacts;
    }


    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }
    public boolean addNewContact(Contact contact){
        if(!myContacts.contains(contact)){
           myContacts.add(contact);
           return true;
        }else{
            return false;
        }
    }
    public boolean updateContact(Contact oldContact,Contact newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition<0){
            return false;
        }if(findContact(newContact.getName()) !=-1){
            return false;
        }
        myContacts.set(foundPosition,newContact);
        return true;
    }
    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        if(foundPosition>=0){
            myContacts.remove(foundPosition);
            return true;
        }else {
            return false;
        }

    }

    public int findContact(Contact contact){
        return myContacts.indexOf(contact);
    }
    public int findContact(String name){
       for(int i=0;i<myContacts.size();i++){
           Contact contact= myContacts.get(i);
           if(contact.getName().equals(name)){
               return i;
           }
       }
       return -1;
    }
    public Contact queryContact(String contactName){
            int position = findContact(contactName);
        if(position>=0){
            return myContacts.get(position);
        }
        return null;

    }


    public void printContact(){
        for(int i=0;i<myContacts.size();i++){
            Contact contact= myContacts.get(i);
            System.out.println(i+1+". "+contact.getName()+" -> "+contact.getPhoneNumber()+"\n");
        }

    }

}
