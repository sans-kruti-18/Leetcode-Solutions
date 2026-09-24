class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;

        boolean[][] vis= new boolean[m][n];
        boolean res=false;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    res=backtrack(board,vis,word,i,j,0);
                    if(res)
                     return true;
                }
            }
        }

        return false;
    }

    public boolean backtrack(char[][] board,boolean[][] vis,String word,int i,int j,int ind)
    {
        if(ind==word.length())
         return true;

        if(i<0 || i>=board.length || j<0 || j>=board[0].length || vis[i][j] ||
         board[i][j]!=word.charAt(ind))
         return false;
        
        vis[i][j]=true;

        if(backtrack(board,vis,word,i,j+1,ind+1) ||
           backtrack(board,vis,word,i,j-1,ind+1) ||
           backtrack(board,vis,word,i+1,j,ind+1) ||
           backtrack(board,vis,word,i-1,j,ind+1) )
             return true;

        vis[i][j]=false;

        return false;
    }
}