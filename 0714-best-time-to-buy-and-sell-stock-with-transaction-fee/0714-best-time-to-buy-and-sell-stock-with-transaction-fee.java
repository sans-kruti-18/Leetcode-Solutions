class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        if(n==0)
         return 0;

        int[][] dp = new int[n+1][2];

        dp[n][0]=dp[n][1]=0;

        for(int ind=n-1;ind>=0;ind--)
        {
            for(int buy=0;buy<=1;buy++)
            {
                int profit;

                if(buy==0)
                 profit= Math.max(0 + dp[ind+1][0], -prices[ind]+ dp[ind+1][1]);
                else
                 profit=Math.max(0 + dp[ind+1][1], prices[ind]+ dp[ind+1][0]-fee);

                dp[ind][buy]=profit;
            }
        }

        return dp[0][0];
    }
}