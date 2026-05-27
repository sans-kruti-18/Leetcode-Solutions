class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n= arr.length;

        int[] dp =new int[n];
        int[] cnt=new int[n];

        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);

        int maxi=1;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[j]<arr[i] && dp[i]<dp[j]+1)
                {
                    dp[i]=dp[j]+1;
                    cnt[i]= cnt[j];
                }

                else if(arr[j]<arr[i] && dp[i]==dp[j]+1)
                 cnt[i]=cnt[i]+cnt[j];
            }

            maxi=Math.max(maxi,dp[i]);
        }

        int count=0;
        for(int i=0;i<n;i++)
        {
            if(dp[i]==maxi)
             count += cnt[i];
        }

        return count;
        
    }
}