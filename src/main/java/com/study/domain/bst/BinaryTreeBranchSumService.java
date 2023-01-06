package com.study.domain.bst;

import com.study.domain.model.BinaryTree;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class BinaryTreeBranchSumService {

    // Using depth-first-search to calculate the sums
    public static List<Integer> branchSums(BinaryTree root) {
        var sums = new ArrayList<Integer>();
        branchSums(root, 0, sums);
        return sums;
    }

    public static void branchSums(BinaryTree node, int currentSum, List<Integer> sums) {
        if (isNull(node)) {
            return;
        }

        var newCurrentSum = currentSum + node.value;

        // end of branches
        if (node.left == null && node.right == null) {
            sums.add(newCurrentSum);
            return;
        }

        branchSums(node.left, newCurrentSum, sums);
        branchSums(node.right, newCurrentSum, sums);
    }
}