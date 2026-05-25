class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;

        int[][] dp= new int[n][2];

        for(int[] row:dp)
         Arrays.fill(row,-1);

        return solve(prices,0,0,n,dp);        
    }

    public int solve(int[] prices,int ind,int buy,int n,int[][] dp)
    {
        if(ind==n)
         return 0;

        if(dp[ind][buy] != -1)
         return dp[ind][buy];

        int profit;

        if(buy==0)
        {
            profit = Math.max(0+solve(prices,ind+1,0,n,dp), -prices[ind]+ solve(prices,ind+1,1,n,dp));
        }
        else
        {
            profit = Math.max(solve(prices,ind+1,1,n,dp), prices[ind]+ solve(prices,ind+1,0,n,dp));
        }

        dp[ind][buy]=profit;

        return profit;
    }
}