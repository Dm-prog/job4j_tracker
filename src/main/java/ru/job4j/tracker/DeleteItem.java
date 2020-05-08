package ru.job4j.tracker;

public class DeleteItem implements UserAction {

    @Override
    public String name() {
        return "=== Delete Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Deletion was performed successfully");
        } else {
            System.out.print("deletion cannot be performed");
        }
        return true;
    }
}
