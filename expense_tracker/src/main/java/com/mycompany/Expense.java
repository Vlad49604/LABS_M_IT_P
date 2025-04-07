package com.mycompany;

public class Expense {
    int exp_id;
    int amount;
    String category;
    String description;
    String date;

    public Expense() {
    }

    public Expense(int exp_id, int amount, String category, String description, String date) {
        this.exp_id = exp_id;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    public int getExp_id() {
        return exp_id;
    }

    public int getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getString() {
        return String.format("%d,%d,%s,%s,%s", exp_id, amount, category, description, date);
    }

    public String getFormattedString() {
        return String.format("ID : %d , Amount : %d , Category : %s , Description : %s , Date : %s", exp_id, amount,
                category, description, date);
    }
}
