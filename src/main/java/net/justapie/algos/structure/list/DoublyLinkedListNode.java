package net.justapie.algos.structure.list;

public class DoublyLinkedListNode<T extends Comparable<? super T>> {
    private T value;
    private DoublyLinkedListNode<T> next;
    private DoublyLinkedListNode<T> prev;

    /**
     * Initialize a node with a predefined value.
     * @param value value of this node
     */
    public DoublyLinkedListNode(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DoublyLinkedListNode<T> getNext() {
        return this.next;
    }

    public void setNext(DoublyLinkedListNode<T> next) {
        this.next = next;
    }

    public DoublyLinkedListNode<T> getPrev() {
        return this.prev;
    }

    public void setPrev(DoublyLinkedListNode<T> prev) {
        this.prev = prev;
    }
}
