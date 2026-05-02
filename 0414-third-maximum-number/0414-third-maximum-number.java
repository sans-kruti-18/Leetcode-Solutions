import java.util.*;

class Solution {
    public int thirdMax(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num); 
        }

       
        if (set.size() < 3) {
            return Collections.max(set);
        }

        // Remove the largest
        set.remove(Collections.max(set));

        // Remove the second largest
        set.remove(Collections.max(set));

        // The third maximum
        return Collections.max(set);
    }
}