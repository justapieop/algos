package net.justapie.algos.algorithm.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuickSort {
    /**
     * Perform a quick sort on the given list.
     * @param a List of elements to perform the sort procedure
     * @param <T> Type of elements that are contained in the list
     */
    public static <T extends Comparable<? super T>> void sort(List<T> a) {
        sort(a,  0, a.size() - 1);
    }

    private static <T extends Comparable<? super T>> void sort(List<T> a, int l, int r) {
        if (r <= l) {
            return;
        }

        int pivot = partition(a, l, r);
        sort(a, l, pivot - 1);
        sort(a, pivot + 1, r);
    }

    private static <T extends Comparable<? super T>> int partition(List<T> a, int l, int r) {
        T pivot = a.get(l);
        int i = l;
        int j = r + 1;

        while (true) {
            while (a.get(++i).compareTo(pivot) < 0) {
                if (i == r) {
                    break;
                }
            }

            while (a.get(--j).compareTo(pivot) > 0) {
                if (j == l) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            Collections.swap(a, i, j);
        }
        Collections.swap(a, l, j);
        return j;
    }
}
