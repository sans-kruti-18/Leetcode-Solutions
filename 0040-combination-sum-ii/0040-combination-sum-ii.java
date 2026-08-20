class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        Arrays.sort(arr);

        findComb(0,target,res,ds,arr);
        return res;
    }

    public void findComb(int ind,int target,List<List<Integer>> res,List<Integer> ds,int[] arr)
    {
        if(target==0)
        {
            res.add(new ArrayList<>(ds));
            return;
        }

        if(ind==arr.length || target<0)
         return;

        ds.add(arr[ind]);
        findComb(ind+1,target-arr[ind],res,ds,arr);
        ds.remove(ds.size()-1);

        int next=ind+1;
        while(next<arr.length && arr[next]==arr[ind])
         next++;

        findComb(next,target,res,ds,arr);
    }

}