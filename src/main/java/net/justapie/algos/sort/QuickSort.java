package net.justapie.algos.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuickSort {
    public static <T> void sort(List<T> a, Comparator<T> cmp) {
        sort(a, cmp, 0, a.size() - 1);
    }

    private static <T> void sort(List<T> a, Comparator<T> cmp, int l, int r) {
        if (r <= l) {
            return;
        }

        int pivot = partition(a, cmp, l, r);
        sort(a, cmp, l, pivot - 1);
        sort(a, cmp, pivot + 1, r);
    }

    private static <T> int partition(List<T> a, Comparator<T> cmp, int l, int r) {
        T pivot = a.get(l);
        int i = l;
        int j = r + 1;

        while (true) {
            while (cmp.compare(a.get(++i), pivot) < 0) {
                if (i == r) {
                    break;
                }
            }

            while (cmp.compare(pivot, a.get(--j)) < 0) {
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
