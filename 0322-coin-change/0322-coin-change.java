import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
       int n=coins.length;

       int[][] dp = new int[n][amount+1];

       for(int target=0;target<=amount;target++)
       {
        if(target%coins[0]==0)
          dp[0][target] = target/coins[0];
        else
          dp[0][target] = (int)(1e9);
       }

       for(int ind=1;ind<n;ind++)
       {
         for(int target=0;target<=amount;target++)
         {
            int not = 0 + dp[ind-1][target];

            int take= Integer.MAX_VALUE;
            if(coins[ind]<=target)
              take= 1 + dp[ind][target-coins[ind]];

            dp[ind][target] = Math.min(take,not);
         }

       }

       int ans = dp[n-1][amount];

       if(ans >= (int)(1e9))
         return -1;

        return ans;
   
   
    }
 
}