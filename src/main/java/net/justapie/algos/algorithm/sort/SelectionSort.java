package net.justapie.algos.algorithm.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SelectionSort {
    /**
     * Perform a selection sort on the given list.
     * @param a List of elements to perform the sort procedure
     * @param <T> Type of elements that are contained in the list
     */
    public static <T extends Comparable<? super T>> void sort(List<T> a) {
        if (a.isEmpty()) {
            return;
        }

        for (int i = 0; i < a.size() - 1; i++) {
            int s = i;
            for (int j = i + 1; j < a.size(); j++) {
                if (a.get(j).compareTo(a.get(s)) < 0) {
                    s = j;
                }
            }
            Collections.swap(a, i, s);
        }
    }
}
