import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, 2 * n);

        // Generate subset sums grouped by size
        List<Integer>[] leftSums = new ArrayList[n + 1];
        List<Integer>[] rightSums = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            leftSums[i] = new ArrayList<>();
            rightSums[i] = new ArrayList<>();
        }

        // Generate all subset sums for left half
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0, bits = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += left[i];
                    bits++;
                }
            }
            leftSums[bits].add(sum);
        }

        // Generate all subset sums for right half
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0, bits = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += right[i];
                    bits++;
                }
            }
            rightSums[bits].add(sum);
        }

        // Sort right side sums for binary search
        for (int i = 0; i <= n; i++) {
            Collections.sort(rightSums[i]);
        }

        int result = Integer.MAX_VALUE;

        // Try all splits
        for (int k = 0; k <= n; k++) {
            List<Integer> leftList = leftSums[k];
            List<Integer> rightList = rightSums[n - k];

            for (int a : leftList) {
                int target = totalSum / 2 - a;

                int idx = Collections.binarySearch(rightList, target);
                if (idx < 0) idx = -idx - 1;

                // Check neighbors
                if (idx < rightList.size()) {
                    int b = rightList.get(idx);
                    result = Math.min(result, Math.abs(totalSum - 2 * (a + b)));
                }
                if (idx > 0) {
                    int b = rightList.get(idx - 1);
                    result = Math.min(result, Math.abs(totalSum - 2 * (a + b)));
                }
            }
        }

        return result;
    }
}