package net.justapie.algos.search;

import java.util.Comparator;
import java.util.List;

public class BinarySearch {
    /**
     * Perform a binary search in a given list of elements.
     * @param a List of sorted elements to perform the search
     * @param cmp Comparison function
     * @param k Target element to search for
     * @return The index of the target element if it is found. Otherwise, it will return -1 as indication of that element is not found. If the list is not sorted, the answer may be wrong.
     * @param <T> Type of elements that are contained in the list
     */
    public static <T> int search(List<T> a, Comparator<T> cmp, T k) {
        return search(a, cmp, 0, a.size() - 1, k);
    }

    private static <T> int search(List<T> a, Comparator<T> cmp, int l, int r, T k) {
        int low = l;
        int high = r;

        while (high >= low) {
            int m = low + (high - low) / 2;

            if (cmp.compare(k, a.get(m)) == 0) {
                return m;
            }

            if (cmp.compare(k, a.get(m)) > 0) {
                low = m + 1;
                continue;
            }

            if (cmp.compare(k, a.get(m)) < 0) {
                high = m - 1;
            }
        }

        return -1;
    }
}
