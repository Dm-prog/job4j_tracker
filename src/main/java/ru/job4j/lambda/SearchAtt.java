package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filterSize1(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterName1(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("bug")) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> predicate) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment a : list) {
            if (predicate.test(a)) {
                rsl.add(a);
            }
        }
        return rsl;
    }

    private static List<Attachment> filterSize2(List<Attachment> elements) {
        Predicate<Attachment> predicate = value -> value.getSize() > 100;
        return filter(elements, predicate);
    }

    private static List<Attachment> filterName2(List<Attachment> elements) {
        Predicate<Attachment> predicate = value -> value.getName().contains("bug");
        return filter(elements, predicate);
    }
}
