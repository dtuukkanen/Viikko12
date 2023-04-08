package com.example.viikko11;


import java.util.Date;

public class Item {
    private String itemNotes;
    private double id;
    private Date date;

    public Item(String itemNotes) {
        this.itemNotes = itemNotes;
        id = Math.random();
        date = new Date();
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



