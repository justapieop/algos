package net.justapie.algos.structure.tree.bst;

public class BinarySearchTree<T extends Comparable<? super T>> {
    private BinarySearchTreeNode<T> root;
    private int numberOfNodes;

    /**
     * Initialize a binary search tree with default values.
     */
    public BinarySearchTree() {
        this.root = null;
        this.numberOfNodes = 0;
    }

    /**
     * Initialize a binary search tree with an initial value.
     */
    public BinarySearchTree(T value) {
        this.root = new BinarySearchTreeNode<>(value);
        this.numberOfNodes = 1;
    }

    public BinarySearchTreeNode<T> getRoot() {
        return this.root;
    }

    public int getNumberOfNodes() {
        return this.numberOfNodes;
    }

    public void setRoot(T value) {
        this.root = new BinarySearchTreeNode<>(value);
    }

    public void insert(T value) {
        if (this.root == null) {
            this.root = new BinarySearchTreeNode<>(value);
        } else {
            BinarySearchTreeNode<T> cur = this.root;
            BinarySearchTreeNode<T> par = null;

            while (cur != null) {
                par = cur;
                if (value.compareTo(par.getValue()) > 0) {
                    cur = cur.getRight();
                    continue;
                }

                if (value.compareTo(par.getValue()) == 0) {
                    return;
                }

                cur = cur.getLeft();
            }

            if ((value.compareTo(par.getValue()) > 0)) {
                par.setRight(value);
            } else {
                par.setLeft(value);
            }
        }
        ++this.numberOfNodes;
    }
}
