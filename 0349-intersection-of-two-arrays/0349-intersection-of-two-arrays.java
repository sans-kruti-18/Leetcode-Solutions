class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> check=new HashSet<>();
        for(int num:nums1)
          check.add(num);

        int[] res=new int[Math.min(nums1.length,nums2.length)];
        int ind=0;

        for(int num:nums2)
        {
            if(check.contains(num))
             {
                res[ind++]=num;
                check.remove(num);
             }
        }

        return Arrays.copyOf(res,ind);
        
    }
}