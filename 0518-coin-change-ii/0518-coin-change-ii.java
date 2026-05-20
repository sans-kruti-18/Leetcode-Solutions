class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];

        for(int target=0;target<=amount;target++)
        {
            if(target%coins[0] == 0)
             dp[0][target] = 1;
            else
             dp[0][target]=0;          
        }

        for(int ind=1;ind<n;ind++)
        {
            for(int target=0;target<=amount;target++)
            {
                int not = dp[ind-1][target];

                int take=0;
                if(coins[ind]<=target)
                  take = dp[ind][target-coins[ind]];

                dp[ind][target]= take+not;
            }
        }

        return dp[n-1][amount];
        
    }
}