class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int total = 0;
        for (int num : nums)
            total += num;

        // ✅ IMPORTANT FIX
        if (total < Math.abs(target))
            return 0;

        if ((total + target) % 2 != 0)
            return 0;

        int newTarget = (total + target) / 2;

        int[][] dp = new int[n][newTarget + 1];

        // Base case
        if (nums[0] == 0)
            dp[0][0] = 2;
        else
            dp[0][0] = 1;

        if (nums[0] != 0 && nums[0] <= newTarget)
            dp[0][nums[0]] = 1;

        // DP
        for (int ind = 1; ind < n; ind++) {
            for (int tar = 0; tar <= newTarget; tar++) {

                int not = dp[ind - 1][tar];

                int take = 0;
                if (nums[ind] <= tar)
                    take = dp[ind - 1][tar - nums[ind]];

                dp[ind][tar] = take + not;
            }
        }

        return dp[n - 1][newTarget];
    }
}