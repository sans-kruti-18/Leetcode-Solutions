import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> temp = new ArrayList<>();

        for (int num : nums) {
            int l = 0, r = temp.size() - 1, ans = temp.size();

            while (l <= r) {
                int mid = (l + r) / 2;
                if (temp.get(mid) >= num) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            if (ans == temp.size())
                temp.add(num);     // append
            else
                temp.set(ans, num); // replace
        }

        return temp.size();
    }
}