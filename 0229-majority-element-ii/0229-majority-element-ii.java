class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int cnt1 = 0, cnt2 = 0; 
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;

        // Extended Boyer-Moore Voting Algorithm
        for (int num : nums)
         {
            if (cnt1 == 0 && el2 != num) 
            {
                cnt1 = 1;
                el1 = num;
            }
             else if (cnt2 == 0 && el1 != num) 
             {
                cnt2 = 1;
                el2 = num;
            } 
            else if (num == el1) 
            {
                cnt1++;
            } 
            else if (num == el2)
             {
                cnt2++;
            } 
            else 
            {
                cnt1--;
                cnt2--;
            }
        }

        // Validate the candidates
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) 
        {
            if (num == el1) cnt1++;
            if (num == el2) cnt2++;
        }

        List<Integer> result = new ArrayList<>();
        int threshold = n / 3;
        if (cnt1 > threshold) result.add(el1);
        if (cnt2 > threshold) result.add(el2);

        return result;
    }
}