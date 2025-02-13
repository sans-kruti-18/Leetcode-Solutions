class Solution {
    public int majorityElement(int[] nums) {
        
        int n = nums.length;
        int cnt = 0;
        int ele = 0; 

        //applying the algorithm:
        for (int i = 0; i < n; i++)
         {
            if (cnt == 0) 
            {
                cnt = 1;
                ele = nums[i];
            }
             else if (ele == nums[i]) 
               cnt++;
            else cnt--;
        }

        //checking if the stored element
        // is the majority element:
        int cnt1 = 0;
        for (int i = 0; i < n; i++)
         {
            if (nums[i] == ele) 
              cnt1++;
        }

        if (cnt1 > (n / 2)) 
          return ele;
        
        return -1;
    }
}