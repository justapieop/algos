package net.justapie.algos.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeSort {
    public static <T> void sort(List<T> a, Comparator<T> cmp) {
        List<T> aux = new ArrayList<>(Collections.nCopies(a.size(), null));
        sort(a, aux, cmp, 0, a.size() - 1);
    }

    private static <T> void sort(List<T> a, List<T> aux, Comparator<T> cmp, int l, int r) {
        if (r <= l) {
            return;
        }

        int m = l + (r - l) / 2;
        sort(a, aux, cmp, l, m);
        sort(a, aux, cmp, m + 1, r);
        merge(a, aux, cmp, l, r, m);
    }

    private static <T> void merge(List<T> a, List<T> aux, Comparator<T> cmp, int l, int r, int m) {
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
            } else if (cmp.compare(aux.get(j), aux.get(i)) > 0) {
                a.set(k, aux.get(j++));
            } else {
                a.set(k, aux.get(i++));
            }
        }
    }
}
