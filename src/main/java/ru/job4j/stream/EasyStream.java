package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {

    private final List<Integer> source;
    private final Function<Integer, Integer> fun;

    public static class Builder {

        List<Integer> source;
        Function<Integer, Integer> fun;

        public Builder(List<Integer> source) {
            this.source = source;
        }

        public Builder(Function<Integer, Integer> fun) {
            this.fun = fun;
        }

        private EasyStream build() {
            return new EasyStream(this);
        }
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream.Builder(source).build();
    }

    public EasyStream map(Function<Integer, Integer> fun) {

        return new EasyStream.Builder(fun).build();

    }

    public EasyStream filter(Predicate<Integer> fun) {

        return this;
    }

    public List<Integer> collect() {
        return List.of();
    }

    public EasyStream(Builder builder) {
        source = builder.source;
        fun = builder.fun;
    }
}
