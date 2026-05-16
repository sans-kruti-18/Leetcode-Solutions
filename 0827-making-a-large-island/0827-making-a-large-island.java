class DisjointSet {
    /* To store the ranks, parents and 
    sizes of different set of vertices */
    int[] rank, parent, size;

    // Constructor
    DisjointSet(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // Function to find ultimate parent
    int findUPar(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findUPar(parent[node]);
    }

    // Function to implement union by size
    void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
        else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

class Solution {
    private boolean isValid(int i, int j, int n) 
    {
        // Return false if pixel is invalid
        if (i < 0 || i >= n) return false;
        if (j < 0 || j >= n) return false;
        
        // Return true if pixel is valid
        return true;
    }

    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DisjointSet ds= new DisjointSet(n*n);

        //step 1
        for(int row=0;row<n;row++)
        {
            for(int col=0;col<n;col++)
            {
                if(grid[row][col]==0)
                  continue;

                int dr[] ={-1,0,1,0};
                int dc[] = {0,1,0,-1};

                for(int i=0;i<4;i++)
                {
                    int nrow =row+dr[i];
                    int ncol = col + dc[i];

                   if( isValid(nrow,ncol,n) && grid[nrow][ncol]==1)
                   {
                      int nodeNo = row*n +col;
                      int adjNodeNo = nrow*n +ncol;
                      ds.unionBySize(nodeNo,adjNodeNo);
                   }
                }
            }
        }

        //step 2

        int mx=0;
        for(int row=0;row<n;row++)
        {
            for(int col=0;col<n;col++)
            {
                if(grid[row][col]==1)
                 continue;

                int dr[] ={-1,0,1,0};
                int dc[] = {0,1,0,-1};

                HashSet<Integer> compo= new HashSet<>();

                for(int i=0;i<4;i++)
                {
                    int nrow=row + dr[i];
                    int ncol = col + dc[i];

                    if(isValid(nrow,ncol,n))
                    {
                        if(grid[nrow][ncol]==1)
                          compo.add(ds.findUPar(nrow*n + ncol));
                    }
                }

                int totalSize=0;
                for(Integer parents: compo)
                {
                    totalSize += ds.size[parents];
                }

                mx= Math.max(mx,totalSize+1);

            }
        }

        for(int cellNo=0; cellNo<n*n; cellNo++)
        {
            mx=Math.max(mx, ds.size[ds.findUPar(cellNo)]);
        }

        return mx;

    }
}