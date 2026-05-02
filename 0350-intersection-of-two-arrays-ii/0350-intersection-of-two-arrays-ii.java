import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        // instead of Set, use Map to store counts
        Map<Integer, Integer> check = new HashMap<>();
        for (int num : nums1) {
            check.put(num, check.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;

        for (int num : nums2) {
            if (check.containsKey(num) && check.get(num) > 0) {
                result[index++] = num;
                check.put(num, check.get(num) - 1); // reduce count
            }
        }

        return Arrays.copyOf(result, index);
    }
}