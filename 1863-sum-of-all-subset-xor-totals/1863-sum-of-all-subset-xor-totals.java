class Solution {
    public int subsetXORSum(int[] nums) {
        
        return xorSum(nums,0,0);
       
    }

    public int xorSum(int[] nums,int ind,int xor)
    {
        if(ind==nums.length)
          return xor;

        int notPick=xorSum(nums,ind+1,xor);
        int pick= xorSum(nums,ind+1,xor^nums[ind]);

        return pick+notPick;
    }
}