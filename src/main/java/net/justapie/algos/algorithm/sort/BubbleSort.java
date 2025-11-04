package net.justapie.algos.algorithm.sort;

import java.util.Collections;
import java.util.List;

public class BubbleSort {
    /**
     * Perform a bubble sort on the given list.
     * @param a List of elements to perform the sort procedure
     * @param <T> Type of elements that are contained in the list
     */
    public static <T extends Comparable<? super T>> void sort(List<T> a) {
        if (a.isEmpty()) {
            return;
        }

        for (int i = 0; i < a.size() - 1; i++) {
            for (int j = 0; j < a.size() - i - 1; j++) {
                if (a.get(j).compareTo((T) a.get(j + 1)) > 0) {
                    Collections.swap(a, j, j + 1);
                }
            }
        }
    }
}
