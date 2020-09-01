package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    School school = new School();

    @Test
    public void whenListAsClass10A() {
        List<Student> expected = new ArrayList<>();
        expected.add(new Student("Ivan", 70));
        expected.add(new Student("Oleg", 80));
        expected.add(new Student("Alexey", 90));
        List<Student> result = school.collect(expected, x -> x.getScore() >= 70 && x.getScore() <= 100);
        assertThat(result, is(expected));
    }

    @Test
    public void whenListAsClass10B() {
        List<Student> expected = new ArrayList<>();
        expected.add(new Student("Evgeniy", 50));
        expected.add(new Student("Svetlana", 55));
        expected.add(new Student("Vladimir", 68));
        List<Student> result = school.collect(expected, x -> x.getScore() >= 50 && x.getScore() < 70);
        assertThat(result, is(expected));
    }

    @Test
    public void whenListAsClass10C() {
        List<Student> expected = new ArrayList<>();
        expected.add(new Student("Boris", 49));
        expected.add(new Student("Egor", 30));
        expected.add(new Student("Anna", 10));
        List<Student> result = school.collect(expected, x -> x.getScore() >= 0 && x.getScore() < 50);
        assertThat(result, is(expected));
    }
}
