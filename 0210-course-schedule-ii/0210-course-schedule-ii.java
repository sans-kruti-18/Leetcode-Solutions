import java.util.*;

class Solution {
    private boolean hasCycle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // 1. Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            adj.get(prerequisite).add(course);
        }

        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];

        Stack<Integer> stack = new Stack<>();

        // 2. DFS for each node
        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                dfs(i, adj, vis, pathVis, stack);
                if (hasCycle) return new int[0];
            }
        }

        // 3. Build result
        int[] res = new int[numCourses];
        int idx = 0;
        while (!stack.isEmpty()) {
            res[idx++] = stack.pop();
        }

        return res;
    }

    private void dfs(int node, List<List<Integer>> adj,
                     int[] vis, int[] pathVis,
                     Stack<Integer> stack) 
    {

        vis[node] = 1;
        pathVis[node] = 1;

        for (int neigh : adj.get(node)) {
            if (vis[neigh] == 0) {
                dfs(neigh, adj, vis, pathVis, stack);
                if (hasCycle) return;
            }
            else if (pathVis[neigh] == 1) {
                hasCycle = true;
                return;
            }
        }

        pathVis[node] = 0;

        
        stack.push(node);
    }
}