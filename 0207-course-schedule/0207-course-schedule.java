import java.util.*;

class Solution {

    public boolean dfs(int node, List<List<Integer>> adj,
                       boolean[] vis, boolean[] pathVis) {

        vis[node] = true;
        pathVis[node] = true;

        for (int neighbour : adj.get(node)) {
            if (!vis[neighbour]) {
                if (dfs(neighbour, adj, vis, pathVis))
                    return true;
            }
            else if (pathVis[neighbour]) {
                // cycle detected
                return true;
            }
        }

        pathVis[node] = false; // backtrack
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course); // directed edge
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (dfs(i, adj, vis, pathVis))
                    return false; // cycle found
            }
        }

        return true; // no cycle
    }
}