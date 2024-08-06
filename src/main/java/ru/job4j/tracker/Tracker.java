package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        int index = 0;
        Item[] result = new Item[size];
        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                result[index++] = items[i];
            }
        }
        return Arrays.copyOf(result, index);
    }

    public Item[] findByName(String key) {
        int index = 0;
        Item[] result = new Item[size];
        for (int i = 0; i < size; i++) {
            if (items[i] != null && key.equals(items[i].getName())) {
                result[index++] = items[i];
            }
        }
        return Arrays.copyOf(result, index);
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            items[index] = item;
            item.setId(id);
            return true;
        }
        return false;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
        }

    }

}





