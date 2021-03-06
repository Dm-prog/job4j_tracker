package ru.job4j.tracker;

public class ReplaceItem implements UserAction {
    @Override
    public String name() {
        return "=== Replace Item ===";
    }

    @Override
    public boolean execute(Input input, Store store) {
        String id = input.askStr("Enter id: ");
        String name = input.askStr("Enter name: ");
        if (store.replace(id, new Item(name))) {
            System.out.println("The replacement was made successfully");
        } else {
            System.out.println("No replacement can be made");
        }
        return true;
    }
}
