package net.justapie.algos.algorithm.sort;

import java.util.Collections;
import java.util.List;

public class QuickSelect {
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

    private static <T extends Comparable<? super T>> T selectKthSmallestElement(List<T> elements, int l, int r, int k) {
        int p = partition(elements, l, r);

        if (p == k - 1) {
            return elements.get(p);
        } else if (p < k - 1) {
            return selectKthSmallestElement(elements, p + 1, r, k);
        } else {
            return selectKthSmallestElement(elements, l, p - 1, k);
        }
    }

    /**
     * Returns the k-th smallest element.
     * @param elements a List of elements having total ordering
     * @param k k-th to choose
     * @return the element that is k-th smallest
     * @param <T> Type of elements that are contained in the list
     */
    public static <T extends Comparable<? super T>> T selectKthSmallestElement(List<T> elements, int k) {
        return selectKthSmallestElement(elements, 0, elements.size() - 1, k);
    }
}
