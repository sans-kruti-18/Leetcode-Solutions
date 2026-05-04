class Solution {
    public int amountOfTime(TreeNode root, int target) {
       
        Map<Integer, List<Integer>> mapToParent = new HashMap<>();
        
        buildGraph(root, null, mapToParent);
        
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
             
                for (int neighbor : mapToParent.getOrDefault(node, new ArrayList<>())) {
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

   
    private void buildGraph(TreeNode node, TreeNode parent, Map<Integer, List<Integer>> mapToParent) {
       
        if (node == null) return;

        // If parent exists, add bidirectional connection
        if (parent != null) {
            mapToParent.computeIfAbsent(node.val, k -> new ArrayList<>()).add(parent.val);
            mapToParent.computeIfAbsent(parent.val, k -> new ArrayList<>()).add(node.val);
        }

        // Recursively build mapToParent for left and right children
        buildGraph(node.left, node, mapToParent);
        buildGraph(node.right, node, mapToParent);
    }
}
