class Solution {
    public int splitArray(int[] nums, int k) {
        if(nums.length<k)
         return -1;

        int low= Arrays.stream(nums).max().getAsInt();
        int high= Arrays.stream(nums).sum();

        while(low<=high)
        {
            int mid=(low+high)/2;
            int partitions= cntPart(nums,mid);

            if(partitions > k)
             low=mid+1;
            else
             high=mid-1;
        }

        return low;        
    }

    public int cntPart(int[] nums,int maxSum)
    {
        int n=nums.length;
        int parts=1;
        int subArraySum=0;

        for(int i=0;i<n;i++)
        {
            if(subArraySum+nums[i] <= maxSum)
             subArraySum += nums[i];
            else
             {
                subArraySum =nums[i];
                parts++;
             }
        }

        return parts;

    }
}