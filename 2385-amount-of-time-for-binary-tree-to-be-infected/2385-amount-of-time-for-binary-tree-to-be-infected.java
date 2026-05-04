/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int amountOfTime(TreeNode root, int target) {
       
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        buildGraph(root, null, graph);
        
        Set<Integer> visited = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burned = false;

            for (int i = 0; i < size; i++) {
                int node = queue.poll();
             
                for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                        burned = true;
                    }
                }
            }

            if (burned) {
                time++;
            }
        }

        return time;
    }

   
    private void buildGraph(TreeNode node, TreeNode parent, Map<Integer, List<Integer>> graph) {
       
        if (node == null) return;

        // If parent exists, add bidirectional connection
        if (parent != null) {
            graph.computeIfAbsent(node.val, k -> new ArrayList<>()).add(parent.val);
            graph.computeIfAbsent(parent.val, k -> new ArrayList<>()).add(node.val);
        }

        // Recursively build graph for left and right children
        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }
}
