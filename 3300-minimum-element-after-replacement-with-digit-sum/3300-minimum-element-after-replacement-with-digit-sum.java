class Solution {
    public int minElement(int[] nums) {
        int mini=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++)
        {
            nums[i]=sum(nums[i]);
            mini=Math.min(mini,nums[i]);
        }
        
        return mini;
    }

    public int sum(int n)
    {
        int total=0;
        while(n>0)
        {
            total += n%10;
            n = n/10;

        }

        return total;
    }
}