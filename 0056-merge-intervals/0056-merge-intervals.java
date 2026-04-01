class Solution {
    public int[][] merge(int[][] arr) {
        
        int n = arr.length;
        if (n == 0) return new int[0][0];

        
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] res = new int[n][2];
        int idx = 0;

        res[0][0] = arr[0][0];
        res[0][1] = arr[0][1];

        for (int i = 1; i < n; i++) {
            // Overlapping interval → merge
            if (arr[i][0] <= res[idx][1]) {
                res[idx][1] = Math.max(res[idx][1], arr[i][1]);
            } 

            else {
                idx++;
                res[idx][0] = arr[i][0];
                res[idx][1] = arr[i][1];
            }
        }

        // Copy only valid merged intervals
        return Arrays.copyOf(res, idx + 1);




        
    }
}