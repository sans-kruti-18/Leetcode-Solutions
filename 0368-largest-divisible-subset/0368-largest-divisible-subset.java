class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        int[] dp= new int[n];
        int[] parent= new int[n];

        Arrays.fill(dp,1);
        for(int i=0;i<n;i++)
         parent[i]=i;

        int maxi=1;
        int lastInd=0;

        Arrays.sort(nums);

        for(int i=0;i<n;i++)
        {
            for(int prev=0;prev<i;prev++)
            {
                if(nums[i]%nums[prev]==0 && dp[i]<dp[prev]+1)
                {
                    dp[i]=dp[prev]+1;
                    parent[i]=prev;
                }
            }   
                
                if(dp[i] > maxi)
                {
                    maxi=dp[i];
                    lastInd=i;
                }            
        }

        List<Integer> lis= new ArrayList<>();
        lis.add(nums[lastInd]);

        while(parent[lastInd] != lastInd)
        {
            lastInd= parent[lastInd];
            lis.add(nums[lastInd]);
        }

        Collections.reverse(lis);

        return lis;


        
    }
}