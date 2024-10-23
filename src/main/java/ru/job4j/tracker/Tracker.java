package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Tracker {
    private final List<Item> collection = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        collection.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? collection.get(index) : null;
    }

    public List<Item> findAll() {
        return new ArrayList<>(collection);

    }

    public Collection<Item> findByName(String key) {
        Collection<Item> result = new ArrayList<>();
        for (Item item : collection) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    public int indexOf(int id) {
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            collection.set(index, item);
        }
        return result;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            collection.remove(index);
        }

    }

}





