import java.util.*;

class Solution {
    public int minimumMountainRemovals(int[] nums) {

        int n = nums.length;

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        // LIS (left → right)
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] > nums[prev] && dp1[i] < dp1[prev] + 1) {
                    dp1[i] = dp1[prev] + 1;
                }
            }
        }

        // LDS (right → left)
        for (int i = n - 1; i >= 0; i--) {
            for (int next = n - 1; next > i; next--) {
                if (nums[i] > nums[next] && dp2[i] < dp2[next] + 1) {
                    dp2[i] = dp2[next] + 1;
                }
            }
        }

        int maxMountain = 0;

        for (int i = 0; i < n; i++) {
            // ✅ important condition
            if (dp1[i] > 1 && dp2[i] > 1) {
                maxMountain = Math.max(maxMountain, dp1[i] + dp2[i] - 1);
            }
        }

        return n - maxMountain;
    }
}
