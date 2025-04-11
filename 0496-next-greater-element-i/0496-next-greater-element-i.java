import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Step 1: Map from element in nums2 to its next greater element
        Map<Integer, Integer> ngeMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            // If the stack is not empty, the top is the next greater element
            if (!stack.isEmpty()) {
                ngeMap.put(nums2[i], stack.peek());
            } else {
                ngeMap.put(nums2[i], -1);
            }

            // Push current element to stack
            stack.push(nums2[i]);
        }

        // Step 2: Prepare result array using the map for nums1
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = ngeMap.get(nums1[i]);
        }

        return res;
    }
}
