package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Store tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Enter select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int i = 0; i < actions.length; i++) {
            System.out.printf("%d. %s%n", i, actions[i].name());
        }
    }


    public static void main(String[] args) {
        Input validate = new ValidateInput(
                new ConsoleInput()
        );
        try (Store tracker = new SqlTracker()) {
            tracker.init();
            UserAction[] actions = {
                    new CreateAction(),
                    new ReplaceItem(),
                    new DeleteItem(),
                    new FindAllAction(),
                    new FindByIdAction(),
                    new FindByNameAction(),
                    new ExitAction()
            };
            new StartUI().init(validate, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
