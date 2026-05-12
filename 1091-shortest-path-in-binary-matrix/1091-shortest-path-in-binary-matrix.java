import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[] src = {0, 0};
        int[] dest = {n - 1, n - 1};

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        if (src[0] == dest[0] && src[1] == dest[1])
            return 1;

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[src[0]][src[1]] = 1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, src[0], src[1]}); 
        int[] drow = {-1,-1,0,1,1,1,0,-1};
        int[] dcol = {0,1,1,1,0,-1,-1,-1};

        while (!q.isEmpty()) {

            int[] curr = q.poll();
            int d = curr[0];
            int r = curr[1];
            int c = curr[2];

            for (int i = 0; i < 8; i++) {

                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    grid[nrow][ncol] == 0 &&
                    d + 1 < dist[nrow][ncol]) {

                    dist[nrow][ncol] = d + 1;

                    if (nrow == dest[0] && ncol == dest[1])
                        return d + 1;

                    q.offer(new int[]{d + 1, nrow, ncol});
                }
            }
        }

        return -1;
    }
}