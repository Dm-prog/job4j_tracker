package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {

    public List<Integer> fromIntegerMatrixToList(Integer[][] integers) {
        return Stream.of(integers).flatMap(e -> Arrays.stream(e)).collect(Collectors.toList());
    }
}

