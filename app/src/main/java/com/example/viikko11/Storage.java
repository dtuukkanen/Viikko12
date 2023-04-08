package com.example.viikko11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Storage {
    private ArrayList<Item> items = new ArrayList<>();
    private static Storage storage = null;

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(double id) {
        int i = 0;
        for (Item item : items) {
            if (item.getId() == id) {
                break;
            }
            i++;
        }
        items.remove(i);
    }

    public Item getItem(int id) {
        return items.get(id);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void sortByName() {
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return item1.getNotes().compareTo(item2.getNotes());
            }
        });
    }

    public void sortByDate() {
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return item1.getDate().compareTo(item2.getDate());
            }
        });
    }
}
