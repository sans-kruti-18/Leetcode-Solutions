class Solution {

    int find(int[] parent,int x)
    {
        if(parent[x]!=x)
          parent[x]=find(parent,parent[x]);

        return parent[x];
    }

    void union(int x,int y, int[] parent,int[] rank)
    {
        if(rank[x] < rank[y])
          parent[x]=y;

        else if(rank[x] > rank[y])
          parent[y]=x;

        else
        {
            parent[y]=x;
            rank[x]++;
        }
    }

    public int makeConnected(int n, int[][] conn) {
        if(conn.length < n-1)
         return -1;

        int[] parent= new int[n];
        int[] rank= new int[n];

        for(int i=0;i<n;i++)
          parent[i]=i;

        int extra=0;

        for(int[] edge: conn)
        {
            int u=edge[0];
            int v=edge[1];

            int pu= find(parent,u);
            int pv= find(parent,v);

            if(pu==pv)
             extra++;

            else
             union(pu,pv,parent,rank);
        }

        int compo=0;
        for(int i=0;i<n;i++)
        {
            if(parent[i]==i)
              compo++;
        }

        if(extra >= compo-1)
         return compo-1;

        return -1;
        

        
    }
}