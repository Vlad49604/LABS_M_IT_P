package com.mycompany;

import java.util.ArrayList;
import java.util.Scanner;
import com.mycompany.Expense;
import com.mycompany.ExpenseStorage;
import com.mycompany.Categories;


public class ExpenseTracker {

    static void waitForEnter() {
        System.out.println("\nPress enter to continue..");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        // arrayList to store categories
        ArrayList<String> categoriesList = Categories.readCategories();
        // arraylist to store object of class expense
        ArrayList<Expense> expObjects = ExpenseStorage.readExpense();
        Scanner sc = new Scanner(System.in);
        int option = 0;
        try {
            while (option != 7) {
                clearScreen();
                System.out.println("\t********************************");
                System.out.println(" \t\tExpense Tracker");
                System.out.println("\t********************************\n");

                System.out.println("1)Add expense");
                System.out.println("2)Delete expense");
                System.out.println("3)Manage categories");
                System.out.println("4)View expense");
                System.out.println("5)Modify expense");
                System.out.println("6)Generate Report");
                System.out.println("7)Exit\n");

                System.out.print("Enter your option :");
                option = sc.nextInt();

                switch (option) {
                    case 1:
                        // Logic for adding expense
                        break;
                    case 2:
                        // Logic for deleting expense
                        break;
                    case 3:
                        // Logic for managing categories
                        break;
                    case 4:
                        // Logic for viewing expenses
                        break;
                    case 5:
                        // Logic for modifying expenses
                        break;
                    case 6:
                        // Logic for generating report
                        break;
                    case 7:
                        clearScreen();
                        System.out.println("\t********************************");
                        System.out.println(" \t\tExpense Tracker");
                        System.out.println("\t********************************\n");
                        System.out.println("Thank you for using our expense tracker, Goodbye...\n");
                        break;
                    default:
                        System.out.println("Invalid Choice. Try Again");
                        waitForEnter();
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Internal Error occured. Program terminated!");
        }
        sc.close();
    }
}
