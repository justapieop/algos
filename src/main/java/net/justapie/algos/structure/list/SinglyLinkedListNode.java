package net.justapie.algos.structure.list;

public class SinglyLinkedListNode<T> {
    private T value;
    private SinglyLinkedListNode<T> next;

    /**
     * Initialize a singly linked list node with a predefined value.
     * @param value value for this node
     */
    public SinglyLinkedListNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public SinglyLinkedListNode<T> getNext() {
        return this.next;
    }

    public void setNext(SinglyLinkedListNode<T> next) {
        this.next = next;
    }
}
