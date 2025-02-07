class Solution {
    public int[][] merge(int[][] intervals) {
        
         if (intervals.length == 0) return new int[0][];
        
        // Step 1: Sort the intervals based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        // Step 2: Merge overlapping intervals
        for (int[] interval : intervals) {
            // If the list is empty or the current interval does not overlap, add it
            if (merged.isEmpty() || interval[0] > merged.get(merged.size() - 1)[1]) {
                merged.add(interval);
            } 
            // If there is an overlap, merge with the last interval
            else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        // Convert List<int[]> to int[][]
        return merged.toArray(new int[merged.size()][]);
    }
}