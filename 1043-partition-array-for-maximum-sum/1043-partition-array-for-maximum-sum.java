class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp= new int[n];
        Arrays.fill(dp,-1);

        return solve(arr,k,0,dp);        
    }

    public int solve(int[] arr,int k,int start,int[] dp)
    {
        int n=arr.length;

        if(start==n)
         return 0;

        if(dp[start] != -1)
         return dp[start];

        int maxSum=0;
        int maxEle=0;

        for(int len=1;len<=k && start+len<=n;len++)
        {
            maxEle = Math.max(maxEle,arr[start+len-1]);

            int currSum = maxEle*len + solve(arr,k,start+len,dp);

            maxSum= Math.max(maxSum,currSum);
        }

        return dp[start]=maxSum;
    }
}