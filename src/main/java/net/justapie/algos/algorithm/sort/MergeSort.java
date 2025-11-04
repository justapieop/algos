package net.justapie.algos.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeSort {
    /**
     * Perform a merge sort on the given list.
     * @param a List of elements to perform the sort procedure
     * @param <T> Type of elements that are contained in the list
     */
    public static <T extends Comparable<? super T>> void sort(List<T> a) {
        List<T> aux = new ArrayList<>(Collections.nCopies(a.size(), null));
        sort(a, aux, 0, a.size() - 1);
    }

    private static <T extends Comparable<? super T>> void sort(List<T> a, List<T> aux, int l, int r) {
        if (r <= l) {
            return;
        }

        int m = l + (r - l) / 2;
        sort(a, aux, l, m);
        sort(a, aux,m + 1, r);
        merge(a, aux, l, r, m);
    }

    private static <T extends Comparable<? super T>> void merge(List<T> a, List<T> aux, int l, int r, int m) {
        for (int i = l; i <= r; i++) {
            aux.set(i, a.get(i));
        }
        int i = l;
        int j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i > m) {
                a.set(k, aux.get(j++));
            } else if (j > r) {
                a.set(k, aux.get(i++));
            } else if (aux.get(j).compareTo(aux.get(i)) < 0) {
                a.set(k, aux.get(j++));
            } else {
                a.set(k, aux.get(i++));
            }
        }
    }
}
