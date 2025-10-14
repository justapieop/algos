package net.justapie.algos.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SelectionSort {
    /**
     * Perform a selection sort on the given list.
     * @param a List of elements to perform the sort procedure
     * @param cmp Comparison function
     * @param <T> Type of elements that are contained in the list
     */
    public static <T> void sort(List<T> a, Comparator<T> cmp) {
        if (a.isEmpty()) {
            return;
        }

        for (int i = 0; i < a.size() - 1; i++) {
            for (int j = i + 1; j < a.size(); j++) {
                if (cmp.compare(a.get(j), a.get(i)) < 0) {
                    Collections.swap(a, i, j);
                }
            }
        }
    }
}
