class Solution {
    public int minGroups(int[][] intervals) {

        int n = intervals.length;

        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int groups = 0;
        int ans = 0;

        int i = 0, j = 0;

        while (i < n) {

            if (start[i] <= end[j]) {
                groups++;
                ans = Math.max(ans, groups);
                i++;
            } else {
                groups--;
                j++;
            }
        }

        return ans;
    }
}