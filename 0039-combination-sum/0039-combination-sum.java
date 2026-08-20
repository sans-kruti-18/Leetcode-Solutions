class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();

        findComb(0,target,res,ds,arr);
        return res;
    }

    public void findComb(int ind,int target,List<List<Integer>> res,List<Integer> ds,int[] arr)
    {
        if(ind==arr.length)
        {
            if(target==0)
             res.add(new ArrayList<>(ds));
            return;
        }

        if(arr[ind]<=target)
        {
            ds.add(arr[ind]);
            findComb(ind,target-arr[ind],res,ds,arr);
            ds.remove(ds.size()-1);
        }

        findComb(ind+1,target,res,ds,arr);
    }
}