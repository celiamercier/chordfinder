package com.tyalis.chordfinder.utils;

import java.util.HashSet;
import java.util.Set;

public class CollectionUtils {

    /**
     * @return return the number of elements in s1 that are also in s2
     */
    public static <T> int numberOfElementContainedIn(Set<T> s1, Set<T> s2) {
        Set<T> tmp = new HashSet<>(s1);
        tmp.retainAll(s2);
        return tmp.size();
    }
}
