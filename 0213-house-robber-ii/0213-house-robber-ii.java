class Solution {

    public long solve(int[] arr)
    {
        if(arr.length==0)
         return 0;

        if(arr.length==1)
         return arr[0];

        long prev2=0;
        long prev=arr[0];

        for(int i=1;i<arr.length;i++)
        {
            long include= arr[i] + prev2;
            long exclude = 0 + prev;

            long curr= Math.max(include,exclude);

            prev2=prev;
            prev=curr;
        }

        return prev;
    }

    public int rob(int[] nums) {
        if(nums.length==0)
         return 0;

        if(nums.length==1)
         return nums[0];

        int[] arr1 = new int[nums.length-1];
        int[] arr2 = new int[nums.length-1];

        for(int i=0;i<nums.length;i++)
        {
            if(i>0)
             arr1[i-1]=nums[i];
            
            if(i < nums.length-1)
             arr2[i]=nums[i];
             
        }

        long ans1= solve(arr1);
        long ans2= solve(arr2);

        return (int)Math.max(ans1,ans2);
        
    }
}