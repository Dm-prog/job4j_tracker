package ru.job4j.lambda;

import ru.job4j.function.Function;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return 0;
            }
        };
        Arrays.sort(atts, comparator);

        //Comparator<Student> comparator =
        //int compare(Student o1, Student o2) - так в этом случае будет выглядеть метод compare
    }

    public static void raw(List<Attachment> list, Function<Attachment, InputStream> func) {
        for (Attachment att : list) {
            func.apply(att);
        }
    }

    InputStream apply(Attachment t) {
        return null;
    }

    //Function<Student, Mark> func = ...
    //Student apply(Mark m) { - так в этом случае будет выглядеть метод apply.
    //    }
}
