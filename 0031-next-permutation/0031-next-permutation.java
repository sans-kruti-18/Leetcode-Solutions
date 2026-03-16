class Solution {
    
    public void reverse(int start,int end,int[] nums)
    {
        while(start<end)
        {
            swap(start,end,nums);
            start++;
            end--;
        }
    }

    public void swap(int i,int j,int[] nums)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    
    public void nextPermutation(int[] nums) {
        int ind=-1;

        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
             {
                ind=i;
                break;
             }
        }

        if(ind==-1)
        {
            reverse(0,nums.length-1,nums);
            return;
        }
        
        for(int i=nums.length-1;i>ind;i--)
        {
            if(nums[i]>nums[ind])
            {
                swap(i,ind,nums);
                break;
            }
        }

        reverse(ind+1,nums.length-1,nums);
        
    }
}