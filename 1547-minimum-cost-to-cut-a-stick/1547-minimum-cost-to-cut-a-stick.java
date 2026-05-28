class Solution {
    public int minCost(int n, int[] cutsArr) {
        int c=cutsArr.length;

        int[] cuts= new int[c+2];

        for(int i=0;i<c;i++)
         cuts[i+1]=cutsArr[i];

        cuts[0]=0;
        cuts[c+1]=n;

        Arrays.sort(cuts);

        int[][] dp= new int[c+1][c+2];
        for(int[] row:dp )
         Arrays.fill(row,-1);

        return solve(1,c,cuts,dp);
               
    }

    public int solve(int i,int j,int[] cuts,int[][] dp)
    {
        if(i>j)
         return 0;

        if(dp[i][j] != -1)
         return dp[i][j];

        int mini= Integer.MAX_VALUE;

        for(int ind=i;ind<=j;ind++)
        {
            int cost = cuts[j+1] - cuts[i-1] + solve(i,ind-1,cuts,dp)
              + solve(ind+1,j,cuts,dp);

            mini= Math.min(mini,cost);
        }

        return dp[i][j]=mini;
    }
}