package ru.job4j.tracker;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Find all ===";
    }

    @Override
    public boolean execute(Input input, Store store) {
        for (Item item : store.findAll()) {
            System.out.printf("%s %s%n", item.getId(), item.getName());
        }
        return true;
    }
}
