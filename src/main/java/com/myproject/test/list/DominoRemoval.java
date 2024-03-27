package com.myproject.test.list;

import java.util.HashMap;
import java.util.Map;

public class DominoRemoval {
    public int solution(int[] A) {
        // Count occurrences of each potential domino pair
        Map<Integer, Integer> count = new HashMap<>();
        int dominoCount = A.length/2;
        for (int i = 0; i < 2 * dominoCount; i += 2) {
            int pair = Math.min(A[i], A[i + 1]) * A.length + Math.max(A[i], A[i + 1]);
            count.put(pair, count.getOrDefault(pair, 0) + 1);
        }

        // Find the maximum occurrence of a pair
        int maxOccurrences = 0;
        for (int value : count.values()) {
            maxOccurrences = Math.max(maxOccurrences, value);
        }

        // Calculate the minimum number of removals required
        int minRemovals = dominoCount - maxOccurrences;

        return minRemovals;
    }

    public static void main(String[] args) {
        DominoRemoval dr = new DominoRemoval();
        int[] A = {5, 1, 2, 6, 6, 1, 3, 1, 4, 3, 4, 3, 4, 6, 1, 2, 4, 1, 6, 2};
        int N = A.length / 2;
        System.out.println(dr.solution(A));
    }
}