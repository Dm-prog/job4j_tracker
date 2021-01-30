package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Store store) {
        String key = input.askStr("question");
        List<Item> result = store.findByName(key);
        for (Item i : result) {
            if (i != null) {
                System.out.println(i);
            } else {
                System.out.println("The item was not found");
            }
        }
        return true;
    }
}
