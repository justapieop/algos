package net.justapie.algos.structure.list;

public class SinglyLinkedList<T extends Comparable<? super T>> {
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /**
     * Initialize a singly linked list with the default value.
     */
    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Insert a value at the end of the list.
     * @param value value to insert
     */
    public void insert(T value) {
        if (this.head == null) {
            this.head = new SinglyLinkedListNode<>(value);
            this.tail = this.head;
        } else {
            this.tail.setNext(new SinglyLinkedListNode<>(value));
            this.tail = this.tail.getNext();
        }

        ++this.size;
    }

    /**
     * Remove the value at the end of the list.
     * @return removed value
     * @throws IllegalStateException if the list if empty
     */
    public T pop() throws IllegalStateException {
        if (this.size == 0) {
            throw new IllegalStateException("list is empty");
        }

        if (this.tail == null) {
            return null;
        }

        T val = this.tail.getValue();

        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
            --this.size;
            return val;
        }

        val = this.tail.getValue();

        SinglyLinkedListNode<T> cur = this.head;
        while (cur.getNext() != this.tail) {
            cur = cur.getNext();
        }

        this.tail = cur;

        --this.size;
        return val;
    }

    /**
     * Insert a value at a defined position in the list.
     * @param value value to inset
     * @param pos position of the list
     * @throws IndexOutOfBoundsException if the position is out of bound [0, size]
     */
    public void insert(T value, int pos) throws IndexOutOfBoundsException {
        if (pos < 0 || pos > this.size) {
            throw new IndexOutOfBoundsException(String.format("pos %d is out of bound 0 and %d", pos, this.size - 1));
        }

        int c = 0;
        SinglyLinkedListNode<T> cur = this.head;
        SinglyLinkedListNode<T> prev = null;
        while (c < pos) {
            prev = cur;
            cur = cur.getNext();
            ++c;
        }

        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(value);

        if (prev == null) {
            newNode.setNext(this.head);
            this.head = newNode;
        } else if (cur == null) {
            this.insert(value);
        } else {
            newNode.setNext(cur);
            prev.setNext(newNode);
        }

        ++this.size;
    }

    /**
     * Remove the value at the specified position.
     * @param pos position of the element
     * @return removed value
     * @throws IndexOutOfBoundsException if the position is out of bound [0, size - 1]
     * @throws IllegalStateException if the list is empty
     */
    public T remove(int pos) throws IndexOutOfBoundsException, IllegalStateException {
        if (this.size == 0) {
            throw new IllegalStateException("list is empty");
        }
        if (pos < 0 || pos >= this.size) {
            throw new IndexOutOfBoundsException(String.format("pos %d is out of bound 0 and %d", pos, this.size - 1));
        }

        int c = 0;

        SinglyLinkedListNode<T> cur = this.head;
        SinglyLinkedListNode<T> prev = null;

        while (c < pos) {
            prev = cur;
            cur = cur.getNext();
            ++c;
        }

        T val;
        if (prev == null) {
            val = this.head.getValue();
            this.head = this.head.getNext();
        } else {
            val = cur.getValue();
            prev.setNext(cur.getNext());
        }

        --this.size;
        return val;
    }

    public SinglyLinkedListNode<T> getHead() {
        return this.head;
    }

    public SinglyLinkedListNode<T> getTail() {
        return this.tail;
    }

    public int getSize() {
        return this.size;
    }
}
