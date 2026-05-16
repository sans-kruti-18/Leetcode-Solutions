class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;

        PriorityQueue<int[]> minHeap= new PriorityQueue<>((a,b)->a[0]-b[0]);

        boolean[][] vis= new boolean[n][n];

        minHeap.add(new int[]{grid[0][0],0,0});
        vis[0][0]=true;

        int[][] dirs= {{0,1},{1,0},{0,-1},{-1,0}};

        while(!minHeap.isEmpty())
        {
            int[] curr= minHeap.poll();
            int ele=curr[0];
            int row=curr[1];
            int col=curr[2];

            if(row==n-1 && col==n-1)
             return ele;

            for(int[] d : dirs)
            {
                int nrow= row+d[0];
                int ncol = col+d[1];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && !vis[nrow][ncol])
                {
                    vis[nrow][ncol]=true;
                    minHeap.add(new int[]{Math.max(ele,grid[nrow][ncol]),nrow,ncol});
                }
            }
        }

        return -1;
    }
}