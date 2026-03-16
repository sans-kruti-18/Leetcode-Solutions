import java.util.*;


class Solution {
    public int longestConsecutive(int[] nums) {

        int n=nums.length;
        int longest=1;

        if(n==0) 
         return 0;

        Set<Integer> st = new HashSet<>();

        for(int i=0;i<n;i++)
        {
            st.add(nums[i]);
        }

        for(int it:st)
        {
            if(!st.contains(it-1))
            {
                int cnt=1;
                int x=it;

                while(st.contains(x+1))
                {
                    x=x+1;
                    cnt++;
                }

                longest=Math.max(longest,cnt);
            }
        }

        return longest;
        
    }
}