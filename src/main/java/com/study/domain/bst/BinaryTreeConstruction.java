package com.study.domain.bst;

import java.util.Objects;

public class BinaryTreeConstruction {
    public static int findClosestValueInBst(BST tree, int target) {
        return findClosest(tree, target, tree.value);
    }

    private static int findClosest(BST tree, int target, int closestValue) {
        var currentNode = tree.value;
        if (Math.abs(target - closestValue) > Math.abs(target - currentNode)){
            closestValue = currentNode;
        }

        if (target < currentNode && Objects.nonNull(tree.left)) {
            return findClosest(tree.left, target, closestValue);
        } else if (target > currentNode && Objects.nonNull(tree.right)) {
            return findClosest(tree.right, target, closestValue);
        } else {
            return closestValue;
        }
    }


    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
