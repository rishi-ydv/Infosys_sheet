package src.easy;

import java.util.*;

public class GoodSubarrayMaxSum {
    public static int maxGoodSubarraySum(int[] arr, int k) {
        int n = arr.length;
        int left = 0, maxSum = 0, currSum = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < n; right++) {
            int num = arr[right];
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            currSum += num;

            // Shrink window if distinct elements > k
            while (freqMap.size() > k) {
                int leftNum = arr[left];
                freqMap.put(leftNum, freqMap.get(leftNum) - 1);
                currSum -= leftNum;
                if (freqMap.get(leftNum) == 0) freqMap.remove(leftNum);
                left++;
            }

            // Avoid negative sums (empty subarray better)
            if (currSum < 0) {
                freqMap.clear(); // reset window
                currSum = 0;
                left = right + 1;
                continue;
            }

            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 1, 3, 2, -1};
        int k = 5;
        // int[] arr = {1, 2, 2, 3, 2, 3, 5, 1, 2, 1, 1};
        // int k = 2;
        // int[] arr = {-1, -2, -3};
        // int k = 1;
        System.out.println(maxGoodSubarraySum(arr, k)); // Output: 6
    }
}

