package net.justapie.algos.algorithm.search;

import java.util.List;

public class LinearSearch {
    /**
     * Perform a linear search.
     * @param a list of elements
     * @param target target to search
     * @return the index of the element if present in the list. -1 if not found
     * @param <T> type of elements in the list
     */
    public static <T> int search(List<T> a, T target) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals(target)) {
                return i;
            }
        }

        return -1;
    }
}
