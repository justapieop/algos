package net.justapie.algos.structure.table;

import net.justapie.algos.structure.list.Chain;
import net.justapie.algos.structure.list.ChainingList;

import java.util.ArrayList;

public class HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 100;

    private final ArrayList<ChainingList<K, V>> list;
    public final int capacity;

    /**
     * Initialize a hash table with the default capacity of 100
     */
    public HashTable() {
        this.list = new ArrayList<>();
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            this.list.add(new ChainingList<>());
        }
        this.capacity = DEFAULT_CAPACITY;
    }

    /**
     * Initialize a hash table with a predefined capacity.
     * @param capacity capacity of the table
     */
    public HashTable(int capacity) {
        this.list = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            this.list.add(new ChainingList<>());
        }
        this.capacity = capacity;
    }

    /**
     * Add a key value pair to the table
     * @param key key of the pair
     * @param value value of the pair
     */
    public void add(K key, V value) {
        int h = this.hash(key);

        Chain<K, V> chain = this.find(key);

        if (chain == null || !chain.getKey().equals(key)) {
            this.list.get(h).insert(key, value);
            return;
        }

        chain.setValue(value);
    }

    /**
     * Remove a key value pair from the table. If the key is found, remove the pair. Otherwise, do nothing.
     * @param key key of the pair to remove
     */
    public void remove(K key) {
        int h = this.hash(key);

        ChainingList<K, V> linkedList = this.list.get(h);

        Chain<K, V> prev = null;
        Chain<K, V> chain = linkedList.getHead();

        while (chain != null) {
            prev = chain;

            if (chain.getKey().equals(key)) {
                break;
            }

            chain = chain.getNext();
        }

        if (prev == null) {
            linkedList.pop();
            return;
        }

        if (chain == null) {
            return;
        }

        prev.setNext(chain.getNext());
    }

    /**
     * Get a value from the table that is associated with the key. Return null if the key is not found.
     * @param key key of the pair
     * @return value of the key pair
     */
    public V get(K key) {
        int h = this.hash(key);

        Chain<K, V> chain = this.find(key);

        if (chain.getKey().equals(key)) {
            return chain.getValue();
        }

        return null;
    }

    /**
     * Check if a key is in the table.
     * @param key key to check
     * @return a boolean value indicating if the key is in the table
     */
    public boolean exists(K key) {
        int h = this.hash(key);

        Chain<K, V> chain = this.find(key);

        return chain.getKey().equals(key);
    }

    private Chain<K, V> find(K key) {
        int h = this.hash(key);
        ChainingList<K, V> linkedList = this.list.get(h);

        Chain<K, V> chain = linkedList.getHead();

        while (chain != null) {
            if (chain.getKey().equals(key)) {
                return chain;
            }
            chain = chain.getNext();
        }

        return linkedList.getTail();
    }

    private int hash(K key) {
        return key.hashCode() % this.capacity;
    }
}
