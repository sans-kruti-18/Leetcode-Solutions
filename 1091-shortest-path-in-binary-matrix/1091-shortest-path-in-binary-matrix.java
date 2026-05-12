import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // single cell grid edge case
        if (n == 1 && grid[0][0] == 0) return 1;

        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, -1);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        dist[0][0] = 1;

        int[] drow = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dcol = {0, 1, 1, 1, 0, -1, -1, -1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int i = 0; i < 8; i++) {
                int nr = r + drow[i];
                int nc = c + dcol[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n &&
                    grid[nr][nc] == 0 && dist[nr][nc] == -1) {

                    dist[nr][nc] = dist[r][c] + 1;

                    if (nr == n - 1 && nc == n - 1)
                        return dist[nr][nc];

                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return -1;
    }
}