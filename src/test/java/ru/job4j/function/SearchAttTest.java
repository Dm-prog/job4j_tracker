package ru.job4j.function;

import org.junit.Test;
import ru.job4j.lambda.SearchAtt;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

public class SearchAttTest {
    ImplementationOfTheFunctions function = new ImplementationOfTheFunctions();

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = function.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = function.diapason(5, 8, x -> x * (x + 1));
        List<Double> expected = Arrays.asList(30D, 42D, 56D);
        assertThat(result, is(expected));
    }
}
