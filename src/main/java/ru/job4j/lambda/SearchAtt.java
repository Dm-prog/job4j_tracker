package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("bug")) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> predicate) {

        return list;
    }

    private static List<Attachment> filterSize(List<Attachment> elements, Predicate<Attachment> predicateFunction) {
        predicateFunction = value -> value.getSize() > 100;
        return elements;
    }

    private static List<Attachment> filterName(List<Attachment> elements, Predicate<Attachment> predicateFilter) {
        predicateFilter = value -> value.getName().contains("bug");
        return elements;
    }



}
