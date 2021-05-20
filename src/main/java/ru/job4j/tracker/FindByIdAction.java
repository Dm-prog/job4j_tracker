package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Store store) {
        String id = input.askStr("question");
        Item found = store.findById(id);
        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("The item was not found");
        }
        return true;
    }
}
