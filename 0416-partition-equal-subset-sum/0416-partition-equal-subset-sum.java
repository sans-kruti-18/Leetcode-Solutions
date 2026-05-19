class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;

        int total=0;
        for(int num:nums)
         total += num;

        if(total%2 ==1)
         return false;

        int k=total/2;

        boolean[][] dp= new boolean[n][k+1];
        
        for(int i=0;i<n;i++)
        {
            dp[i][0]=true;
        }

        if(nums[0]<=k)
         dp[0][nums[0]]=true;

        for(int ind=1;ind<n;ind++)
        {
            for(int target=1;target<=k;target++)
            {
                boolean notTake=dp[ind-1][target];

                boolean take=false;
                if(nums[ind]<=target)
                 take= dp[ind-1][target-nums[ind]];

                dp[ind][target]= take||notTake;
            }
        }

        return dp[n-1][k];
        
    }
}