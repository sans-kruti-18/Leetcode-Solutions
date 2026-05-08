class Solution {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    cnt++;
                    dfs(i, j, grid, visited);
                }
            }
        }
        return cnt;
    }

    public void dfs(int row, int col, char[][] grid, boolean[][] visited) {

        int m = grid.length;
        int n = grid[0].length;

        visited[row][col] = true;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if (nrow >= 0 && nrow < m &&
                ncol >= 0 && ncol < n &&
                grid[nrow][ncol] == '1' &&
                !visited[nrow][ncol]) {

                dfs(nrow, ncol, grid, visited);
            }
        }
    }
}