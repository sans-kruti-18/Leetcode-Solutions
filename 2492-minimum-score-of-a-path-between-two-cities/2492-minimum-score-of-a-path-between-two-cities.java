import java.util.*;

class Solution {
    public int minScore(int n, int[][] roads) {
        // Step 1: Build the adjacency list
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int weight = road[2];
            graph[u].add(new int[]{v, weight});
            graph[v].add(new int[]{u, weight});
        }
        
        // Step 2: Initialize BFS queue and visited array
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        
        queue.offer(1);
        visited[1] = true;
        int minScore = Integer.MAX_VALUE;
        
        // Step 3: Traverse the graph component
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int[] neighbor : graph[current]) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                
                // Track the overall minimum weight seen in this component
                minScore = Math.min(minScore, weight);
                
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }
        
        return minScore;
    }
}
