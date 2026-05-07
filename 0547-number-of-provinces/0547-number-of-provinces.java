class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v=isConnected.length;
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<v;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                if (isConnected[i][j] == 1 && i != j)
                {
                  adj.get(i).add(j);
                  adj.get(j).add(i);
                }
            }
        }

        boolean[] visited=new boolean[v+1];
        int cnt=0;

        for(int i=0;i<v;i++)
        {
            if(!visited[i])
            {
                cnt++;
                dfs(i,adj,visited);
            }
        }

        return cnt;       
    }

    public void dfs(int node,List<List<Integer>> adj,boolean[] visited)
    {
        visited[node]=true;

        for(int neighbour:adj.get(node))
        {
            if(!visited[neighbour])
              dfs(neighbour,adj,visited);
        }

    }
}