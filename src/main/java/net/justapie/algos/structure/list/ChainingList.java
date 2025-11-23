package net.justapie.algos.structure.list;

public class ChainingList<K, V> {
    private Chain<K, V> head;
    private Chain<K, V> tail;
    private int size;

    public ChainingList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Insert a value at the end of the list.
     * @param value value to insert
     */
    public void insert(K key, V value) {
        if (this.head == null) {
            this.head = new Chain<>(key, value);
            this.tail = this.head;
        } else {
            this.tail.setNext(new Chain<>(key, value));
            this.tail = this.tail.getNext();
        }

        ++this.size;
    }

    /**
     * Remove the value at the end of the list.
     * @return removed value
     * @throws IllegalStateException if the list is empty
     */
    public V pop() throws IllegalStateException {
        if (this.size == 0) {
            throw new IllegalStateException("list is empty");
        }

        V val = this.tail.getValue();

        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
            --this.size;
            return val;
        }

        val = this.tail.getValue();

        Chain<K, V> cur = this.head;
        while (cur.getNext() != this.tail) {
            cur = cur.getNext();
        }

        this.tail = cur;

        --this.size;
        return val;
    }

    public Chain<K, V> getTail() {
        return this.tail;
    }

    public Chain<K, V> getHead() {
        return this.head;
    }

    public int getSize() {
        return this.size;
    }
}
