class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // Pointers for nums1, nums2, and the last index to fill
        int i = m - 1; // Last valid element in nums1
        int j = n - 1; // Last element in nums2
        int k = m + n - 1; // Last index of nums1

        // Merge in reverse order to avoid overwriting elements in nums1
        while (i >= 0 && j >= 0) 
        {
            if (nums1[i] > nums2[j])
             {
                nums1[k] = nums1[i];
                i--;
            } 
            else
             {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If there are remaining elements in nums2, copy them to nums1
        while (j >= 0) 
        {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}