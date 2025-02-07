class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans = new ArrayList<>();

        for (int row = 1; row <= numRows; row++)
         {
            List<Integer> ansRow = new ArrayList<>();
            long prod = 1;
            ansRow.add(1); // First element 1

            for (int col = 1; col < row; col++) 
            {
                prod = prod * (row - col);
                prod = prod / col;
                ansRow.add((int) prod);
            }

            ans.add(ansRow);
        }
        return ans;
        
    }
}