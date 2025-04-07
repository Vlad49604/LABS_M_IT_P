package com.mycompany;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class ExpenseStorage {

    public static void storeExpense(ArrayList<Expense> expObjects) {
        File myFile = new File("expense.txt");
        if (!myFile.exists()) {
            try {
                myFile.createNewFile();
            } catch (Exception e) {
                System.out.println("Cannot create File! " + e.getMessage());
            }
        }

        try (FileWriter myFileWriter = new FileWriter("expense.txt")) {
            for (Expense expense : expObjects) {
                myFileWriter.write(expense.getString() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Cannot store the data");
            e.printStackTrace();
        }
    }

    public static ArrayList<Expense> readExpense() {
        File myFile = new File("expense.txt");
        ArrayList<Expense> expObjects = new ArrayList<>();
        if (myFile.exists()) {
            try (Scanner sc = new Scanner(myFile)) {
                while (sc.hasNextLine()) {
                    String str = sc.nextLine();
                    String[] expInfo = str.split(",");
                    if (expInfo.length == 5) {
                        Expense exp = new Expense(Integer.valueOf(expInfo[0]), Integer.valueOf(expInfo[1]),
                                expInfo[2], expInfo[3], expInfo[4]);
                        expObjects.add(exp);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return expObjects;
    }
}
