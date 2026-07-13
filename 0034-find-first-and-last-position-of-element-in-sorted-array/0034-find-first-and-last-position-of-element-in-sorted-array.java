class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int ft=first(nums,target,n);

        if(ft==-1)
         return new int[]{-1,-1};

        int lt=last(nums,target,n);

        return new int[]{ft,lt};
    }

    public int first(int[] arr,int k,int n)
    {
        int low=0;
        int high=n-1;
        int first=-1;

        while(low<=high)
        {
            int mid=(low+high)/2;

            if(arr[mid]==k)
            {
                first=mid;
                high=mid-1;
            }
            else if(arr[mid]<k)
             low=mid+1;
            else 
             high=mid-1;
        }

        return first;
    }

    public int last(int[] arr,int k,int n)
    {
        int low=0;
        int high=n-1;
        int last=-1;

        while(low<=high)
        {
            int mid=(low+high)/2;

            if(arr[mid]==k)
            {
                last=mid;
                low=mid+1;
            }
            else if(arr[mid]<k)
             low=mid+1;
            else
             high=mid-1;
        }

        return last;
    }
}