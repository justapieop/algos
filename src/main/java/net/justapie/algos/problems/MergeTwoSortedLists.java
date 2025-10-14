package net.justapie.algos.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeTwoSortedLists {
    /**
     * Merge two sorted lists a and b into a new list.
     * @param a List a
     * @param b List b
     * @param cmp Comparison function
     * @return A new list that is merged from a and b
     * @param <T> Type of elements that are contained in the list
     */
    public static <T> List<T> mergeToNewList(List<T> a, List<T> b, Comparator<T> cmp) {
        List<T> result = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < a.size() && j < b.size()) {
            if (cmp.compare(a.get(i), b.get(j)) <= 0) {
                result.add(a.get(i));
                i++;
            } else {
                result.add(b.get(j));
                j++;
            }
        }

        while (i < a.size()) {
            result.add(a.get(i));
            i++;
        }

        while (j < b.size()) {
            result.add(b.get(j));
            j++;
        }

        return result;
    }
}
