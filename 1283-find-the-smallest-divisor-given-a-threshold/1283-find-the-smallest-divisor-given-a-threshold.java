class Solution {
    public int smallestDivisor(int[] nums, int limit) {
        if(nums.length>limit)
         return -1;

        int low=1;
        int high =Arrays.stream(nums).max().getAsInt();

        while(low<=high)
        {
            int mid=(low+high)/2;

            if(sumByD(nums,mid) <= limit)
             high = mid-1;
            else 
             low=mid+1;
        }
        return low;
    }

    int sumByD(int[] nums,int d)
    {
        int sum=0;

        for(int num:nums)
        {
            sum+= Math.ceil((double)num/d);
        }

        return sum;
    }
}