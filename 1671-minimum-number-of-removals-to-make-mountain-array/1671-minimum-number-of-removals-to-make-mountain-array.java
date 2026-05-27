import java.util.*;

class Solution {
    public int minimumMountainRemovals(int[] nums) {

        int n = nums.length;

        int[] LIS = new int[n];
        int[] LDS = new int[n];

        Arrays.fill(LIS, 1);
        Arrays.fill(LDS, 1);

        // LIS (left → right)
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] > nums[prev] && LIS[i] < LIS[prev] + 1) {
                    LIS[i] = LIS[prev] + 1;
                }
            }
        }

        // LDS (right → left)
        for (int i = n - 1; i >= 0; i--) {
            for (int next = n - 1; next > i; next--) {
                if (nums[i] > nums[next] && LDS[i] < LDS[next] + 1) {
                    LDS[i] = LDS[next] + 1;
                }
            }
        }

        int maxMountain = 0;

        for (int i = 0; i < n; i++) {
            // ✅ important condition
            if (LIS[i] > 1 && LDS[i] > 1) {
                maxMountain = Math.max(maxMountain, LIS[i] + LDS[i] - 1);
            }
        }

        return n - maxMountain;
    }
}
