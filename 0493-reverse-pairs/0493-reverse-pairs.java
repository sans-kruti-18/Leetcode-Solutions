class Solution {
    public int reversePairs(int[] nums) {
        int n=nums.length;
        return mergeSort(nums,0,n-1);
        
    }

    public static int mergeSort(int[] nums,int low,int high)
    {
        int cnt=0;
        if(low>=high)
         return cnt;
        int mid=(low+high)/2;

        cnt += mergeSort(nums,low,mid);
        cnt += mergeSort(nums,mid+1,high);
        cnt += countPairs(nums,low,mid,high);
        merge(nums,low,mid,high);
        return cnt;
    }

    public static int countPairs(int[] nums,int low,int mid,int high)
    {
        
        int right = mid + 1;
        int cnt = 0;

        for (int i = low; i <= mid; i++) {   // ✅ FIXED
            while (right <= high && nums[i] > 2L * nums[right]) {
                right++;
            }
            cnt += right - (mid + 1);
        }

        return cnt;

    }

    public static void merge(int[] nums,int low,int mid,int high)
    {
        ArrayList<Integer> temp=new ArrayList<>();
        int left=low;
        int right=mid+1;

        while(left<=mid && right<=high)
        {
            if(nums[left]<=nums[right])
            {
                temp.add(nums[left]);
                left++;
            }
            else
            {
                temp.add(nums[right]);
                right++;
            }
        }

        while(left<=mid)
        {
            temp.add(nums[left]);
            left++;
        }

        while(right<=high)
        {
            temp.add(nums[right]);
            right++;
        }

        for(int i=low;i<=high;i++)
        {
            nums[i]=temp.get(i-low);
        }
    }
}