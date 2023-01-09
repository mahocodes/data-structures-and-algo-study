package com.study.domain;

import java.util.List;
import java.util.Map;

public class ApartmentHunting {

    // You're looking to move into a new apartment on specific street, and you're given a list of contiguous blocks on
    // that street where each block contains an apartment that you could move into. The apartment is a Map<String, Boolean>
    // where the key string is the establishment name and the value is a flag that indicates if you have that store in the block or not.
    // You're also given a list of required establishments that you would like to have in your block.
    // In order to optimize your life, you want to pick an apartment block such that you minimize the farthest distance
    // you'd have to walk from your apartment to reach any of your required buildings.
    // Write a function that takes in this list of mapped blocks and a list of your required establishments
    // Return the index of the most optimal choice for your apartment block.

    // Solution
    // Time complexity of O(B²R) where B is the number of blocks in the list and R is the number of requirements
    // B is squared because we iterate through all the blocks and for each of the blocks we iterate through all the requirements
    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        var minDistancesFromBlocks = new int[reqs.length][];

        // iterate through all the requirements
        for (var i = 0; i < reqs.length; i++) {
            minDistancesFromBlocks[i] = getMinDistances(blocks, reqs[i]);
        }
        var maxDistancesAtBlocks = getMaxDistancesAtBlocks(blocks, minDistancesFromBlocks);
        return getIdxAtMinValue(maxDistancesAtBlocks);
    }


    public static int[] getMinDistances(List<Map<String, Boolean>> blocks, String req) {
        var minDistances = new int[blocks.size()];
        // keep track of the closest block id
        var closestReqIdx = Integer.MAX_VALUE;

        // For each block check if they have the required building of the closest idx that has it
        for (var i = 0; i < blocks.size(); i++) {
            if (blocks.get(i).get(req)) closestReqIdx = i;
            minDistances[i] = distanceBetween(i, closestReqIdx);
        }
        for (var i = blocks.size() - 1; i >= 0; i--) {
            if (blocks.get(i).get(req)) closestReqIdx = i;
            minDistances[i] = Math.min(minDistances[i], distanceBetween(i, closestReqIdx));
        }
        return minDistances;
    }

    public static int[] getMaxDistancesAtBlocks(
            List<Map<String, Boolean>> blocks, int[][] minDistancesFromBlocks) {
        var maxDistancesAtBlocks = new int[blocks.size()];
        for (int i = 0; i < blocks.size(); i++) {
            var minDistancesAtBlock = new int[minDistancesFromBlocks.length];
            for (var j = 0; j < minDistancesFromBlocks.length; j++) {
                minDistancesAtBlock[j] = minDistancesFromBlocks[j][i];
            }
            maxDistancesAtBlocks[i] = arrayMax(minDistancesAtBlock);
        }
        return maxDistancesAtBlocks;
    }

    public static int getIdxAtMinValue(int[] array) {
        var idxAtMinValue = 0;
        var minValue = Integer.MAX_VALUE;
        for (var i = 0; i < array.length; i++) {
            var currentValue = array[i];
            if (currentValue < minValue) {
                minValue = currentValue;
                idxAtMinValue = i;
            }
        }
        return idxAtMinValue;
    }

    public static int distanceBetween(int a, int b) {
        return Math.abs(a - b);
    }

    public static int arrayMax(int[] array) {
        var max = array[0];
        for (var a : array) {
            if (a > max) {
                max = a;
            }
        }
        return max;
    }
}
