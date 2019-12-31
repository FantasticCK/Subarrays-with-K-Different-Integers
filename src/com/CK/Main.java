package com.CK;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Solution().subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2);
    }
}

class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }
    int atMostK(int[] A, int K) {
        int l = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int r = 0; r < A.length; ++r) {
            if (count.getOrDefault(A[r], 0) == 0) K--;
            count.put(A[r], count.getOrDefault(A[r], 0) + 1);
            while (K < 0) {
                count.put(A[l], count.get(A[l]) - 1);
                if (count.get(A[l]) == 0) K++;
                l++;
            }
            res += r - l + 1;
        }
        return res;
    }
}