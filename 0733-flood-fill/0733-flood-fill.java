class Solution {
    
    public void dfs(int row,int col,int[][] image,int[][] ans,int[] drow,int[] dcol,int iniCol,int newCol)
    {
        int n=image.length;
        int m=image[0].length;

        ans[row][col]= newCol;

        for(int i=0;i<4;i++)
        {
            int nrow= row+drow[i];
            int ncol= col+dcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==iniCol && ans[nrow][ncol]!=newCol)
              dfs(nrow,ncol,image,ans,drow,dcol,iniCol,newCol);

        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int iniCol= image[sr][sc];
        int[][] ans= image;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};

        
        if (iniCol == color) 
            return image;
        
        dfs(sr,sc,image,ans,drow,dcol,iniCol,color);

        return ans;
    }
}