class Solution {
    public int lengthOfLIS(int[] arr) {
        int n=arr.length;
        int[][] dp=new int[n][n+1];

        for(int[] row:dp)
         Arrays.fill(row,-1);

        return solve(0,-1,arr,n,dp);
    }

    public int solve(int ind,int prev_ind,int[] arr,int n,int[][] dp)
    {
        if(ind==n)
         return 0;

        if(dp[ind][prev_ind+1] != -1)
         return dp[ind][prev_ind+1];

        int notTake = 0 + solve(ind+1,prev_ind,arr,n,dp);

        int take=0;
        if(prev_ind== -1 || arr[ind]>arr[prev_ind])
          take = 1 + solve(ind+1,ind,arr,n,dp);

        return dp[ind][prev_ind+1]=Math.max(take,notTake);

    }
}