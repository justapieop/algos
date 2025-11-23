package net.justapie.algos.structure.tree.bst;

public class BinarySearchTreeNode<T extends Comparable<? super T>> {
    private T value;
    private BinarySearchTreeNode<T> left;
    private BinarySearchTreeNode<T> right;

    /**
     * Initialize a binary search tree node with a predefined value.
     * @param value value for this node
     */
    public BinarySearchTreeNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public BinarySearchTreeNode<T> getLeft() {
        return this.left;
    }

    public BinarySearchTreeNode<T> getRight() {
        return this.right;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setLeft(T left) {
        this.left = new BinarySearchTreeNode<>(left);
    }

    public void setRight(T right) {
        this.right = new BinarySearchTreeNode<>(right);
    }
}
