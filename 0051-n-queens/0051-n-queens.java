class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res= new ArrayList<>();
        char[][] board=new char[n][n];

        for(char[] row:board)
         Arrays.fill(row,'.');

        int leftRow[]=new int[n];
        int upDig[]=new int[2*n-1];
        int lowDig[]=new int[2*n-1];

        solve(0,n,board,leftRow,upDig,lowDig,res);
        return res;
    }

    public void solve(int col,int n,char[][] board,int[] leftRow,int[] upDig,int[] lowDig,List<List<String>> res)
    {
        if(col==n)
        {
            List<String> temp=new ArrayList<>();
            for(int i=0;i<n;i++)
              temp.add(new String(board[i]));

            res.add(temp);
            return;            
        }

        for(int row=0;row<n;row++)
        {
            if(leftRow[row]==0 && lowDig[row+col]==0 && upDig[n-1+col-row]==0)
            {
                board[row][col]='Q';
                leftRow[row]=1;
                lowDig[row+col]=1;
                upDig[n-1+col-row]=1;
                
                solve(col+1,n,board,leftRow,upDig,lowDig,res);

                board[row][col]='.';
                leftRow[row]=0;
                lowDig[row+col]=0;
                upDig[n-1+col-row]=0;
            }
        }
    }
}