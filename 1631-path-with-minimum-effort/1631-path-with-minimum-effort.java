class Solution {
    public int minimumEffortPath(int[][] heights) {

        int n=heights.length;
        int m=heights[0].length;

        PriorityQueue<int[]> pq= new PriorityQueue<>(Comparator.comparingInt(a->a[0]));

        int[][] dist=new int[n][m];
        for(int[] row:dist)
          Arrays.fill(row,Integer.MAX_VALUE);

        dist[0][0]=0;
        pq.add(new int[]{0,0,0});

        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};

        while(!pq.isEmpty())
        {
            int[] curr=pq.poll();
            int diff=curr[0];
            int row=curr[1];
            int col=curr[2];

            if(row==n-1 && col==m-1)
             return diff;

            for(int i=0;i<4;i++)
            {
                int nrow= row+ drow[i];
                int ncol= col+ dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m)
                {
                    int newEffort= Math.max(diff,Math.abs(heights[row][col]-heights[nrow][ncol]));

                    if(newEffort < dist[nrow][ncol])
                     {
                        dist[nrow][ncol]= newEffort;
                        pq.add(new int[]{newEffort,nrow,ncol});
                     }
                }
            }
        }

        return 0;
        
    }
}