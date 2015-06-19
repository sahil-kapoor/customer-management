package cn.javis.apms.helper.utils;

import java.util.ArrayList;
import java.util.Collections;

public final class Lists {
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<E>();
    }

    public static <E> ArrayList<E> newArrayList(E... elements) {
        if (elements != null) {
            ArrayList<E> list = new ArrayList<E>(elements.length);
            Collections.addAll(list, elements);
            return list;
        }
        return new ArrayList<E>();
    }
}
