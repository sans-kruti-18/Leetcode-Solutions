class Solution {

    public void swap(int nums[],int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    
    public void sortColors(int[] nums) {
        // int start=0;
        // int end=nums.length-1;
        // int index=0;
        // while(index<=end)
        // {
        //     if(nums[index]==0)
        //     {
        //         swap(nums,index,start);
        //         start++;
        //         index++;

        //     }else if(nums[index]==2)
        //     {
        //         swap(nums,index,end);
        //         end--;
        //     }
        //     else{
        //         index++;

        //     }
        // }

        //deutch national flag algorithm

        int low = 0, mid = 0, high = nums.length - 1; 

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap nums[low] and nums[mid]
                // int temp = nums[low];
                // nums[low] = nums[mid];
                // nums[mid] = temp;
                swap(nums,low,mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { 
                // Swap nums[mid] and nums[high]
                // int temp = nums[mid];
                // nums[mid] = nums[high];
                // nums[high] = temp;
                swap(nums,mid,high);
                
                high--;
            }
    }

    
}
}
