package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {

    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner myObj = new Scanner(System.in);

        while (true) {
            System.out.println("User, Enter 0, 1 or 2 values:");
            int number = myObj.nextInt();
            myObj.nextLine(); // newline karakterini tüketmek için eklenen satır

            while (number < 0 || number > 2) {
                System.out.println("Yanlış bir değer girdiniz, tekrar deneyin.");
                number = myObj.nextInt();
                myObj.nextLine(); // newline karakterini tüketmek için eklenen satır
            }

            System.out.println("Girilen kullanıcı değeri : " + number);

            if (number == 0) {
                System.out.println("Exiting program");
                break;
            } else if (number == 1) {
                System.out.println("Eklenmesini istediğiniz elemanları giriniz (tek bir eleman ya da virgüllerle ayırarak birden çok eleman girebilirsiniz):");
                String input = myObj.nextLine();
                addItems(input);
            } else if (number == 2) {
                System.out.println("Çıkarılmasını istediğiniz elemanları giriniz (tek bir eleman ya da virgüllerle ayırarak birden çok eleman girebilirsiniz):");
                String input = myObj.nextLine();
                removeItems(input);
            }

            printSorted();
        }

        myObj.close();
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim();
            if (!checkItemIsInList(item)) {
                groceryList.add(item);
            }
        }
        sortList();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim();
            if (checkItemIsInList(item)) {
                groceryList.remove(item);
            }
        }
        sortList();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        sortList();
        System.out.println("Grocery listesi: " + groceryList);
    }

    private static void sortList() {
        Collections.sort(groceryList);
    }

}
