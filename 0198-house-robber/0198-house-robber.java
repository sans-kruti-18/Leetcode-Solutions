class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)
         return 0;

        int prev2=0;
        int prev= nums[0];

        for(int i=1;i<nums.length;i++)
        {
            int include = nums[i] + prev2;
            int exclude = 0 + prev;

            int curr= Math.max(include,exclude);

            prev2=prev;
            prev=curr;
        }

        return prev;
        
    }
}