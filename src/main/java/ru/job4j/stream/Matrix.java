package ru.job4j.stream;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {
    public static void main(String[] args) {
        Integer[][] integers = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Stream.of(integers).flatMap(e -> Arrays.stream(e)).collect(Collectors.toList()));
    }
}

