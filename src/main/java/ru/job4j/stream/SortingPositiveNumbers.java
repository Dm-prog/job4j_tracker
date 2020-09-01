package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortingPositiveNumbers {
    List<Integer> sort = new ArrayList<>(Arrays.asList(3, -5, -2, 4, -10));
    List<Integer> filter = sort.stream().filter(sort -> sort.intValue() > 0).collect(Collectors.toList());
}
