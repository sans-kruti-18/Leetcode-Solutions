class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] temp = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            int l = 0, r = len - 1, ans = len;

            while (l <= r) {
                int mid = (l + r) / 2;
                if (temp[mid] >= num) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            temp[ans] = num;
            if (ans == len) len++;
        }

        return len;
    }
}