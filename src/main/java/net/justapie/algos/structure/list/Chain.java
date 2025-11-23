package net.justapie.algos.structure.list;

public class Chain<K, V> {
    private K key;
    private V value;
    private Chain<K, V> next;

    /**
     * Initialize a Chain object with a predefined key and value.
     * @param key key of the chain
     * @param value value of the chain
     */
    public Chain(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Chain<K, V> getNext() {
        return this.next;
    }

    public void setNext(Chain<K, V> next) {
        this.next = next;
    }
}
