class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {

        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) 
            adj[i] = new ArrayList<>();
        

        for (int[] path : paths) 
        {
            int u = path[0] - 1;
            int v = path[1] - 1;

            adj[u].add(v);
            adj[v].add(u);
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) 
        {

            boolean[] used = new boolean[5];

            for (int neigh : adj[i]) 
                used[ans[neigh]] = true;
            

            for (int flower = 1; flower <= 4; flower++) 
            {

                if (!used[flower]) 
                {
                    ans[i] = flower;
                    break;
                }
            }
        }

        return ans;
    }
}