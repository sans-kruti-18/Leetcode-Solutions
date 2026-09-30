class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k) - atmost(nums,k-1);
    }

    public int atmost(int[] nums,int k)
    {
        if(k<=0)
         return 0;

        Map<Integer,Integer> mp=new HashMap<>();

        int l=0;
        int cnt=0;

        for(int r=0;r<nums.length;r++)
        {
            int val=nums[r];

            mp.put(val,mp.getOrDefault(val,0)+1);

            while(mp.size() > k)
            {
                int leftChar=nums[l];

                mp.put(leftChar,mp.get(leftChar)-1);

                if(mp.get(leftChar)==0)
                 mp.remove(leftChar);

                l++;
            }

            cnt += r - l +1;
        }

        return cnt;
    }
}