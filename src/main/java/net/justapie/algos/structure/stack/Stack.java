package net.justapie.algos.structure.stack;

import net.justapie.algos.structure.list.SinglyLinkedList;

public class Stack<T extends Comparable<? super T>> {
    private final SinglyLinkedList<T> list;

    /**
     * Initialize an empty stack.
     */
    public Stack() {
        this.list = new SinglyLinkedList<>();
    }

    /**
     * Get the head element of the stack.
     * @return the head element
     * @throws IllegalStateException if the stack is empty
     */
    public T peek() throws IllegalStateException {
        if (this.list.getSize() == 0) {
            throw new IllegalStateException("stack is empty");
        }

        return this.list.getTail().getValue();
    }

    /**
     * Add a value to the stack.
     * @param value value to add
     */
    public void add(T value) {
        this.list.insert(value);
    }

    /**
     * Remove the head element of the stack.
     * @return removed value
     * @throws IllegalStateException if the stack is empty
     */
    public T pop() throws IllegalStateException {
        return this.list.pop();
    }

    public int getSize() {
        return this.list.getSize();
    }
}
