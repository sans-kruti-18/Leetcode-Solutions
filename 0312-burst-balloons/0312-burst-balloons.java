class Solution {
    public int maxCoins(int[] numsArr) {
        int n=numsArr.length;

        int[] nums= new int[n+2];

        for(int i=0;i<n;i++)
         nums[i+1]=numsArr[i];

        nums[0]=1;
        nums[n+1]=1;

        int[][] dp = new int[n+2][n+2];
        for(int[] row:dp)
         Arrays.fill(row,-1);

        return solve(1,n,nums,dp);
                
    }

    public int solve(int i,int j,int[] nums, int[][] dp)
    {
        if(i>j)
         return 0;

        if(dp[i][j]!=-1)
         return dp[i][j];

        int maxi=Integer.MIN_VALUE;

        for(int ind=i;ind<=j;ind++)
        {
            int cost = nums[i-1]*nums[ind]*nums[j+1] 
                +solve(i,ind-1,nums,dp) + solve(ind+1,j,nums,dp);

            maxi=Math.max(maxi,cost);
        }

        return dp[i][j]=maxi;
    }
}