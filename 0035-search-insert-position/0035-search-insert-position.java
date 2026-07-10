class Solution {
    public int searchInsert(int[] arr, int x) {
        int low = 0;                  // Start index
        int high = arr.length - 1;    // End index
        int ans = arr.length;         // Default value if not found

        while (low <= high) {
            int mid = (low + high) / 2;  // Find mid index

            if (arr[mid] >= x) {
                ans = mid;            // Store possible answer
                high = mid - 1;       // Move left
            } else {
                low = mid + 1;        // Move right
            }
        }
        return ans; 
    }
}