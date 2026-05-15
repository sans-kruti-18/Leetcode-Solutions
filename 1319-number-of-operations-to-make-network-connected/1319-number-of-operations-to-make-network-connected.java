import java.util.*;

public class Solution {

    public int makeConnected(int n, int[][] connections) {

        int[] parent = new int[n];
        int[] rank = new int[n];

        // Initialize parent
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int extraEdges = 0;

        // Process each connection
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];

            int pu = find(parent, u);
            int pv = find(parent, v);

            // If both have same parent → extra edge
            if (pu == pv) {
                extraEdges++;
            } else {
                union(parent, rank, pu, pv);
            }
        }

        // Count number of components
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (find(parent, i) == i) {
                components++;
            }
        }

        int neededEdges = components - 1;

        // Check if we can connect all components
        if (extraEdges >= neededEdges) {
            return neededEdges;
        }

        return -1;
    }

    // Find with path compression
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    // Union by rank
    private void union(int[] parent, int[] rank, int x, int y) {
        if (rank[x] < rank[y]) {
            parent[x] = y;
        } else if (rank[x] > rank[y]) {
            parent[y] = x;
        } else {
            parent[y] = x;
            rank[x]++;
        }
    }
}