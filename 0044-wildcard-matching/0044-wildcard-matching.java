class Solution {
    public boolean isMatch(String s, String p) {
        int n=p.length();
        int m=s.length();

        int[][] dp = new int[n][m];
        for(int[] row:dp)
         Arrays.fill(row,-1);

         return solve(s,p,n-1,m-1,dp);         
    }

    public boolean solve(String s, String p,int i,int j,int[][] dp)
    {
        if(i<0 && j<0)
         return true;

        if(i<0 && j>=0)
         return false;

        if(i>=0 && j<0)
          return isAllStar(p,i);

        if(dp[i][j]!=-1)
         return dp[i][j]==1;

        if(s.charAt(j)==p.charAt(i) || p.charAt(i)=='?')
         {
            if(solve(s,p,i-1,j-1,dp)==true)
             dp[i][j]=1;
            else
             dp[i][j]=0;
         }

         else if(p.charAt(i)=='*')
         {
            if(solve(s,p,i-1,j,dp) || solve(s,p,i,j-1,dp))
              dp[i][j]=1;
             else
              dp[i][j]=0;
         }

         else
          dp[i][j]=0;

        return dp[i][j]==1;
        
    }

    public boolean isAllStar(String s,int i)
    {
        for(int j=0;j<=i;j++)
        {
            if(s.charAt(j) != '*')
             return false;
        }

        return true;
    }
}