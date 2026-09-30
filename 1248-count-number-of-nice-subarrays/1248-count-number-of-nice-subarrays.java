class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }

    public int atmost(int[] nums,int k)
    {
        if(k<0)
         return 0;

        int l=0;
        int oddcnt=0;
        int cnt=0;

        for(int r=0;r<nums.length;r++)
        {
            if(nums[r]%2 != 0)
             oddcnt++;

            while(oddcnt>k)
            {
                if(nums[l]%2 != 0)
                 oddcnt--;
                l++;
            }

            cnt += r-l+1;
        }

        return cnt;
    }
}