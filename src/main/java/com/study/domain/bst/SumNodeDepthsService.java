package com.study.domain.bst;

import com.study.domain.model.BinaryTree;

import static java.util.Objects.isNull;

public class SumNodeDepthsService {

    // Write a function that takes in a Binary Tree and returns the sum of its nodes' depths.
    // We know that the root node depth is zero and its children are one (root node + 1)
    // The function would be the nodes depth plus (the nodes depth plus one) plus (the nodes depth plus one) to sum node, left child and right child
    // When we reach a null node, it is the end of our tree
    // Complexity O(n|k) where n is the number of nodes and k is the max depth (height) of our tree
    public static int nodeDepths(BinaryTree root) {
        return nodeDepthsSum(root, 0);
    }

    private static int nodeDepthsSum(BinaryTree node, int depth) {
        if (isNull(node)) {
            return 0;
        }

        return depth + nodeDepthsSum(node.left, depth + 1) + nodeDepthsSum(node.right, depth + 1);
    }
}
