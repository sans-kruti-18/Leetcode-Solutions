class Solution {

    public int[] gardenNoAdj(int n, int[][] paths) {

        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] path : paths) {
            int u = path[0] - 1;
            int v = path[1] - 1;

            adj[u].add(v);
            adj[v].add(u);
        }

        int[] color = new int[n];

        solve(0, adj, color, n);

        return color;
    }

    private boolean solve(int node, List<Integer>[] adj,
                          int[] color, int n) {

        if (node == n) {
            return true;
        }

        for (int col = 1; col <= 4; col++) {

            if (isSafe(node, col, adj, color)) {

                color[node] = col;

                if (solve(node + 1, adj, color, n))
                    return true;

                color[node] = 0;
            }
        }

        return false;
    }

    private boolean isSafe(int node, int col,
                           List<Integer>[] adj,
                           int[] color) {

        for (int neigh : adj[node]) {

            if (color[neigh] == col)
                return false;
        }

        return true;
    }
}