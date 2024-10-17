package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Collection;

public class Tracker {
    Collection<Item> collection = new ArrayList<>();

    public Item add(Item item) {
        collection.add(item);
        return item;
    }

    public Item findById(int id) {
        for (Item item : collection) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Collection<Item> findAll() {
        return collection;

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
        int index = 0;
        for (Item item : collection) {
            if (item.getId() == id) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        for (Item rep : collection) {
            if (rep.getId() == id) {
                collection.remove(rep);
                collection.add(item);
                break;
            }
        }
        return result;
    }

    public void delete(int id) {
        int index = indexOf(id);
        for (Item rep : collection) {
            if (index != -1 && rep.getId() == id) {
                collection.remove(rep);
                break;
            }
        }

    }

}





