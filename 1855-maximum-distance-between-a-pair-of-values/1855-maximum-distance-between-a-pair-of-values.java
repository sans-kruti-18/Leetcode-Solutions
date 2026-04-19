class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        final int m = nums1.length, n = nums2.length;
        int ret = 0;
        int lastIdx = 0;
        for (int i = 0; i < m; i++) {
            int l = Math.max(i, lastIdx), r = n - 1;
            int idx = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums1[i] <= nums2[mid]) {
                    idx = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if (idx != -1) {
                ret = Math.max(ret, idx - i);
                lastIdx = idx;
            }
        }
        return ret;
        
    }
}