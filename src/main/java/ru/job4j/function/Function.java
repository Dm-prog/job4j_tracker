package ru.job4j.function;

public interface Function<T, R> {
    R apply(T t);
}
