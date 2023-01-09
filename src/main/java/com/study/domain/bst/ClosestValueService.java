package com.study.domain.bst;

import com.study.domain.model.BinaryTree;

import static java.util.Objects.nonNull;

public class ClosestValueService {

    // Write a function that takes in a Binary Search Tree (BST) and a target integer value and returns the closest value to that target value contained in the BST.
    // Reminders:
    // 1. Nodes to right are greater than or equal to the current node
    // 2. Nodes to left are smaller than the current node

    // Start setting an initial max value (or the root value) to a variable to keep track of the closest value
    // Check if the absolut difference between the target and the closest node is greater than the difference between the target and current node
    // If the target is smaller than the current node, we move to the left
    // If the target is greater thant the current node, we move to the right
    // If the target is equal to current node, we've found a perfect match

    // for example, for the target 12 and current node 10 we go to the left to get a greater value than 10 and be closest to 12
    // then we call the function recursively passing the left node, the target and the current closest value

    // Complexity O(n) at the worst case and O(logn) avg
    public static int findClosestValueInBst(BinaryTree tree, int target) {
        return findClosest(tree, target, tree.value);
    }

    private static int findClosest(BinaryTree tree, int target, int closestValue) {
        var currentNode = tree.value;
        if (Math.abs(target - closestValue) > Math.abs(target - currentNode)){
            closestValue = currentNode;
        }

        if (target < currentNode && nonNull(tree.left)) {
            return findClosest(tree.left, target, closestValue);
        } else if (target > currentNode && nonNull(tree.right)) {
            return findClosest(tree.right, target, closestValue);
        } else {
            return closestValue;
        }
    }
}
