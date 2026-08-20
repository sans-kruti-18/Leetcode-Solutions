class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> ds=new ArrayList<>();

        subset(k,1,n,ds,res);
        return res;
    }

    public void subset(int k,int num,int target,List<Integer> ds,List<List<Integer>> res)
    {
        if(target==0 && k==0)
        {
            res.add(new ArrayList<>(ds));
            return;
        }

        if(num>9 || target<0 || k<0)
         return;

        ds.add(num);
        subset(k-1,num+1,target-num,ds,res);
        ds.remove(ds.size()-1);

        subset(k,num+1,target,ds,res);
    }
}