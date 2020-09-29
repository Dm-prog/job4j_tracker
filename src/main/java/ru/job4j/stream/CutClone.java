package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    }

    public Map<String, Student> sortStudent(List<Student> studentList) {
        Map<String, Student> collect = List.of(
                studentList.get(0),
                studentList.get(1),
                studentList.get(2),
                studentList.get(3))
                .stream().distinct().collect(Collectors.toMap(e -> e.getSurname(), e -> e));
        return collect;
    }
}
