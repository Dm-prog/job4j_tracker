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

        List<Student> students = new ArrayList<>();
        students.add(new Student("Ivanov", 1));
        students.add(new Student("Petrov", 1));
        students.add(new Student("Sidorov", 1));
        students.add(new Student("Ivanov", 1));
        System.out.println(new CutClone().sortStudent(students));
    }

    public Map<String, Student> sortStudent(List<Student> studentList) {
        return studentList.stream().collect(Collectors.toMap(
                e -> e.getSurname(), e -> e, (o, o2) -> o));
    }
}
