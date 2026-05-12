import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        if (n == 1) return 1;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        q.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        int[] drow = {-1,-1,0,1,1,1,0,-1};
        int[] dcol = {0,1,1,1,0,-1,-1,-1};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            for (int i = 0; i < 8; i++) 
            {   
                int nr = r + drow[i];
                int nc = c + dcol[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n &&
                    grid[nr][nc] == 0 && !visited[nr][nc]) 
                    {

                      if (nr == n - 1 && nc == n - 1)
                        return d + 1;

                      visited[nr][nc] = true;
                      q.offer(new int[]{nr, nc, d + 1});
                }
            }
        }

        return -1;
    }
}