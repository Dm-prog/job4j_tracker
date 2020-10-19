package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    Matrix matrix = new Matrix();

    @Test
    public void fromIntegerMatrixToListInteger() {
        Integer[][] integers = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> result = matrix.fromIntegerMatrixToList(integers);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(result, is(expected));
    }
}
