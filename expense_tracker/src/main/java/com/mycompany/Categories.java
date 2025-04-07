package com.mycompany;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Categories {

    public static void storeCategories(ArrayList<String> categories) {
        File categoriesFile = new File("categories.txt");
        if (!categoriesFile.exists()) {
            try {
                categoriesFile.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try (FileWriter categoriesFileWriter = new FileWriter("categories.txt")) {
            for (String category : categories) {
                categoriesFileWriter.write(category.toLowerCase() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> readCategories() {
        ArrayList<String> categories = new ArrayList<>();
        File categoriesFile = new File("categories.txt");
        if (categoriesFile.exists()) {
            try (Scanner sc = new Scanner(categoriesFile)) {
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    categories.add(line);
                }
            } catch (Exception e) {
                System.out.println("Cannot retrieve categories from file.");
            }
        }
        return categories;
    }
}
