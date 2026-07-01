class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new LinkedList<>();
        List<Integer> res=new ArrayList<>();

        for(int i=0;i<nums.length;i++)
        {
            if(!dq.isEmpty() && dq.peekFirst() <= i-k)
             dq.pollFirst();

            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i])
              dq.pollLast();

            dq.offerLast(i);

            if(i >= k-1)
              res.add(nums[dq.peekFirst()]);
        }

        
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
        {
            ans[i] = res.get(i);
        }

        return ans;

        
    }
}