package net.justapie.algos.structure.list;

public class DoublyLinkedList<T> {
    private DoublyLinkedListNode<T> head;
    private DoublyLinkedListNode<T> tail;
    private int size;

    /**
     * Initialize a doubly linked list with the default value.
     */
    public DoublyLinkedList() {
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
            this.head = new DoublyLinkedListNode<>(value);
            this.tail = this.head;
        } else {
            DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(value);
            newNode.setPrev(this.tail);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }

        ++this.size;
    }

    /**
     * Remove the value at the end of the list.
     * @return removed value
     * @throws IllegalStateException if the list is empty
     */
    public T pop() throws IllegalStateException {
        if (this.size == 0) {
            throw new IllegalStateException("list is empty");
        }

        T val = this.tail.getValue();

        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail.setPrev(null);
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
        }

        --this.size;
        return val;
    }

    /**
     * Insert a value at a defined position in the list.
     * @param value value to inset
     * @param pos position of the list
     * @throws IndexOutOfBoundsException if the position is out of bound [0, size]
     */
    public void insert(T value, int pos) throws IndexOutOfBoundsException, IllegalStateException {
        if (pos < 0 || pos > this.size) {
            throw new IndexOutOfBoundsException(String.format("pos %d is out of bound 0 and %d", pos, this.size - 1));
        }

        int c = 0;
        DoublyLinkedListNode<T> prev = null;
        DoublyLinkedListNode<T> cur = this.head;

        while (c < pos) {
            prev = cur;
            cur = cur.getNext();
            ++c;
        }

        DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(value);

        if (prev == null) {
            this.head.setPrev(newNode);
            newNode.setNext(this.head);
            this.head = newNode;
        } else if (cur == null) {
            this.insert(value);
        } else {
            newNode.setPrev(prev);
            prev.setNext(newNode);
            newNode.setNext(cur);
            cur.setPrev(newNode);
        }

        ++this.size;
    }

    /**
     * Remove the value at the specified position.
     * @param pos position of the element
     * @return removed value
     * @throws IndexOutOfBoundsException if the position is out of bound [0, size - 1]
     */
    public T remove(int pos) throws IndexOutOfBoundsException {
        if (pos < 0 || pos >= this.size) {
            throw new IndexOutOfBoundsException(String.format("pos %d is out of bound 0 and %d", pos, this.size - 1));
        }

        T val;

        int c = 0;
        DoublyLinkedListNode<T> prev = null;
        DoublyLinkedListNode<T> cur = this.head;

        while (c < pos) {
            prev = cur;
            cur = cur.getNext();
            ++c;
        }

        if (prev == null) {
            val = this.head.getValue();
            this.pop();
        } else {
            val = cur.getValue();
            prev.setNext(cur.getNext());
            cur.setPrev(null);
            if (cur.getNext() != null) {
                cur.getNext().setPrev(prev);
            }
        }

        --this.size;
        return val;
    }

    public int getSize() {
        return this.size;
    }

    public DoublyLinkedListNode<T> getHead() {
        return this.head;
    }

    public DoublyLinkedListNode<T> getTail() {
        return this.tail;
    }
}
