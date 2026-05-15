import java.util.*;

class Solution {

    int[] parent;

    // Find with path compression
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px != py) {
            parent[px] = py;
        }
    }

    public int removeStones(int[][] stones) {

        int n = stones.length;

        // Max possible index = 10000 (given) + offset
        int offset = 10001;
        parent = new int[20002];  // enough space for rows + cols

        // Initialize parent
        for (int i = 0; i < 20002; i++) {
            parent[i] = i;
        }

        // Connect row and column
        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + offset;

            union(row, col);
        }

        // Count unique components
        Set<Integer> components = new HashSet<>();

        for (int[] stone : stones) {
            components.add(find(stone[0]));
        }

        return stones.length - components.size();
    }
}
