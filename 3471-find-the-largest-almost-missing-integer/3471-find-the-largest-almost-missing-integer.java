class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        int n = nums.length;

        for (int start = 0; start <= n - k; start++) 
        {
            Set<Integer> seen = new HashSet<>();

            for (int i = start; i < start + k; i++) 
            {
                seen.add(nums[i]);
            }

            for (int x : seen) 
            {
                count.put(x, count.getOrDefault(x, 0) + 1);
            }
        }

        int ans = -1;

        for (Map.Entry<Integer, Integer> ent : count.entrySet()) 
        {
            if (ent.getValue() == 1) {
                ans = Math.max(ans, ent.getKey());
            }
        }

        return ans;
    }
}