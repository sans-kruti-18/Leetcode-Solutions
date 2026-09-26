class Solution {

    int[][] jobs;
    Integer[] dp;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = startTime.length;

        jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        dp = new Integer[n];

        return solve(0);
    }

    private int solve(int idx) {

        if (idx >= jobs.length)
            return 0;

        if (dp[idx] != null)
            return dp[idx];

        // Take current job
        int nextIdx = findNextJob(jobs[idx][1]);

        int take = jobs[idx][2] + solve(nextIdx);

        // Skip current job
        int notTake = solve(idx + 1);

        return dp[idx] = Math.max(take, notTake);
    }

    private int findNextJob(int endTime) {

        int low = 0;
        int high = jobs.length - 1;
        int ans = jobs.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (jobs[mid][0] >= endTime) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}