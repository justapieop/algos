package net.justapie.algos.problems;

import net.justapie.algos.structure.tree.bst.BinarySearchTree;
import net.justapie.algos.structure.tree.bst.BinarySearchTreeNode;

import java.util.Stack;

public class GreaterSumTree {
    private static void traverse(BinarySearchTreeNode<Integer> bstNode, Stack<Integer> st) {
        if (bstNode == null) {
            return;
        }

        traverse(bstNode.getRight(), st);

        int val = st.pop();
        int newSum = val + bstNode.getValue();

        bstNode.setValue(newSum);

        st.add(newSum);

        traverse(bstNode.getLeft(), st);
    }

    /**
     * Returns a list of elements that represents the greater sum tree
     * @param bst binary search tree
     * @return list of elements
     */
    public static BinarySearchTree<Integer> calculateSum(BinarySearchTree<Integer> bst) {
        Stack<Integer> st = new Stack<>();
        st.add(0);

        traverse(bst.getRoot(), st);

        return bst;
    }
}
