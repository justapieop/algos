package net.justapie.algos.structure.queue;

import net.justapie.algos.structure.list.SinglyLinkedList;

public class Queue<T extends Comparable<? super T>> {
    private final SinglyLinkedList<T> list;

    /**
     * Initialize an empty queue.
     */
    public Queue() {
        this.list = new SinglyLinkedList<>();
    }

    /**
     * Return the head element of the queue
     * @return head element of the queue
     */
    public T head() {
        return this.list.getHead().getValue();
    }

    /**
     * Returns the last element of the queue.
     * @return last element of the queue
     */
    public T tail() {
        return this.list.getTail().getValue();
    }

    /**
     * Enqueue an element.
     * @param value value to enqueue
     */
    public void enqueue(T value) {
        this.list.insert(value);
    }

    /**
     * Dequeue the first element of the queue.
     * @return dequeued element
     * @throws IllegalStateException if the queue is empty
     */
    public T dequeue() throws IllegalStateException {
        return this.list.remove(0);
    }

    public int getSize() {
        return this.list.getSize();
    }
}
