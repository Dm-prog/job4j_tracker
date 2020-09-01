package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CutClone {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Ivan");
        names.add("Stepan");
        names.add("Petrucho");
        names.add("Ivan");
        names.stream()
                .distinct()
                .forEach(System.out::println);

        Map<String, Student> collect = List.of(
                new Student("Иванов", 1),
                new Student("Петров", 1),
                new Student("Сидоров", 1))
                .stream().collect(Collectors.toMap(e -> e.getSurname(), e -> e));

    }
}
