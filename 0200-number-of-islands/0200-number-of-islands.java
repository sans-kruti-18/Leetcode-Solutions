class Solution {

    public void dfs(int row,int col,int[][] vis,char[][] grid,int[] drow,int[] dcol)
    {
        vis[row][col]=1;
        int n=grid.length;
        int m=grid[0].length;

        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{row,col});

        while(!q.isEmpty())
        {
            int[] cell=q.poll();
            int r=cell[0];
            int c= cell[1];

            for( int i=0;i<4;i++)
            {
                
                    int nrow=r+drow[i];
                    int ncol=c+dcol[i];

                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]=='1')
                    {
                        vis[nrow][ncol]=1;
                        dfs(nrow,ncol,vis,grid,drow,dcol);
                    }
                
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[][] vis=new int[n][m];
        int cnt=0;

        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && grid[i][j]=='1')
                {
                    cnt++;
                    dfs(i,j,vis,grid,drow,dcol);
                }
            }
        }

        return cnt;
        
    }
}