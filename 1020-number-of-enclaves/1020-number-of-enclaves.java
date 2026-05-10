class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        Queue<int[]> q= new LinkedList<>();
        int[][] vis=new int[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0 || i==n-1 || j==0 || j==m-1)
                {
                    if(grid[i][j]==1)
                    {
                        q.add(new int[]{i,j});
                        vis[i][j]=1;
                    }
                }
            }
        }

        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};

        while(!q.isEmpty())
        {
            int[] cell=q.poll();
            int row=cell[0];
            int col=cell[1];

            for(int i=0;i<4;i++)
            {
                int nrow= row+drow[i];
                int ncol= col+dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0)
                {
                    q.add(new int[]{nrow,ncol});
                    vis[nrow][ncol]=1;
                }
            }
        }

        int cnt=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==0)
                  cnt++;
            }
        }

        return cnt;
        
    }
}