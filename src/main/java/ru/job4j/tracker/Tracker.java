package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tracker implements Store {

    private final Item[] items = new Item[100];

    private int position = 0;

    @Override
    public void init() {

    }

    public Item add(Item item) {
        item.setId(generateId());
        this.items[position++] = item;
        return item;
    }

    public List<Item> findAll() {
        return Arrays.asList(items);
    }

    public List<Item> findByName(String key) {
        int size = 0;
        Item[] result = new Item[position];
        for (int index = 0; index < position; index++) {
            Item item = items[index];
            if (item.getName().equals(key)) {
                result[size] = item;
                size++;
            }
        }
        return Arrays.asList(result);
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            result = true;
        }
        return result;
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        if (index != -1) {
            int start = index + 1;
            int size = position - index;
            items[position - 1] = null;
            position--;
            System.arraycopy(items, start, items, index, size);
        }
        return true;
    }

    @Override
    public void close() {

    }
}