class Solution {
    private int timer=1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++)
          adj.add(new ArrayList<>());

        for(List<Integer> conn: connections)
        {
            int u=conn.get(0);
            int v=conn.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis= new boolean[n];
        int[] tin= new int[n];
        int[] low= new int[n];
        List<List<Integer>> bridges= new ArrayList<>();

        dfs(0,-1,adj,vis,tin,low,bridges);

        return bridges;
    }

    void dfs(int node, int parent,List<List<Integer>> adj,boolean[] vis,int[] tin,int[] low,List<List<Integer>> bridges)
    {
        vis[node]=true;
        tin[node]=low[node]=timer++;

        for(int neigh:adj.get(node))
        {
            if(neigh==parent)
              continue;

            if(!vis[neigh])
            {
                dfs(neigh,node,adj,vis,tin,low,bridges);

                low[node]=Math.min(low[node],low[neigh]);

                if(low[neigh] > tin[node])
                  bridges.add(Arrays.asList(neigh,node));
            }

            else
              low[node]=Math.min(low[node],low[neigh]);
        }
    }
}