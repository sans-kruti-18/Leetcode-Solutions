class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       Set<Integer> seen=new HashSet<>();

       for(int num:nums)
       {
          seen.add(num);
       }

       List<Integer> res=new ArrayList<>();
       for(int i=1;i<=nums.length;i++)
       {
          if(!seen.contains(i))
            res.add(i);
       }

       return res;
      
    }
}