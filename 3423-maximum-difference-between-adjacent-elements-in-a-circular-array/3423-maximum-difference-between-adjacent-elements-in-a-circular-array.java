class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int maxi=0;
        int i;

        for(i=0;i<nums.length-1;i++)
        {
            maxi=Math.max(maxi,Math.abs(nums[i]-nums[i+1]));
        }
        maxi=Math.max(maxi,Math.abs(nums[i]-nums[0]));
        return maxi;
    }
}