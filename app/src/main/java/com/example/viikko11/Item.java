package com.example.viikko11;


import java.util.Date;

public class Item {
    private String itemNotes;
    private double id;
    private Date date;
    private boolean importantItem;

    public Item(String itemNotes, boolean importantItem) {
        this.itemNotes = itemNotes;
        id = Math.random();
        date = new Date();
        this.importantItem = importantItem;
    }

    public void setNotes(String itemNotes) {
        this.itemNotes = itemNotes;
    }

    public String getNotes() {
        return itemNotes;
    }

    public double getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }
}



