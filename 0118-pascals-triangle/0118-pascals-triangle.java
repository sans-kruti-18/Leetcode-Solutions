class Solution {
    public List<List<Integer>> generate(int numRows) {
        int n=numRows;

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=1;i<=n;i++)
        {
            List<Integer> row=new ArrayList<>();
            long prod=1;
            row.add(1);
            for(int j=1;j<i;j++)
            {
                prod = prod*(i-j);
                prod=prod/j;
                row.add((int)prod);
            }
            ans.add(row);
        }

        return ans;
        
    }
}