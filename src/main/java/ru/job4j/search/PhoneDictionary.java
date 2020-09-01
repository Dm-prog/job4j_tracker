package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combineName = x -> x.getName().equals(key);
        Predicate<Person> combineSurname = x -> x.getSurname().equals(key);
        Predicate<Person> combinePhone = x -> x.getPhone().equals(key);
        Predicate<Person> combineAddress = x -> x.getAddress().equals(key);
        Predicate<Person> combineAll;
        combineAll = x -> {
            combineSurname.or(combinePhone.or(combineAddress));
            combineSurname.or(combineName);
            return true;
        };

        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combineAll.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
