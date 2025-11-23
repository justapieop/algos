package net.justapie.algos;

import net.justapie.algos.problems.MergeTwoSortedLists;
import net.justapie.algos.structure.list.SinglyLinkedList;
import net.justapie.algos.structure.list.SinglyLinkedListNode;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();

        ll.insert(1);
        ll.insert(2);
        ll.insert(3);

        ll.remove(3);

        SinglyLinkedListNode<Integer> cur = ll.getHead();

        while (cur != null) {
            System.out.println(cur.getValue());
            cur = cur.getNext();
        }
    }
}
