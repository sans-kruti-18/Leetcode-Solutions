class Solution {
    // Track numbers used in each row, column, and 3x3 block
    private boolean[][] rows = new boolean[9][9];
    private boolean[][] cols = new boolean[9][9];
    private boolean[][][] blocks = new boolean[3][3][9];
    private boolean solved = false;

    public void solveSudoku(char[][] board) {
        // Initialize tracking structures with pre-filled numbers
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1'; // Convert char digit to 0-8 index
                    rows[i][num] = true;
                    cols[j][num] = true;
                    blocks[i / 3][j / 3][num] = true;
                }
            }
        }
        backtrack(board, 0, 0);
    }

    private void backtrack(char[][] board, int r, int c) {
        if (r == 9) { // Base case: all rows processed
            solved = true;
            return;
        }

        int nextR = r + (c + 1) / 9; // Calculate next row
        int nextC = (c + 1) % 9; // Calculate next column

        if (board[r][c] != '.') {
            backtrack(board, nextR, nextC); // Skip filled cells
            return;
        }

        // Try digits 1 through 9
        for (int num = 0; num < 9; num++) {
            if (!rows[r][num] && !cols[c][num] && !blocks[r / 3][c / 3][num]) {
                // Place the number
                rows[r][num] = true;
                cols[c][num] = true;
                blocks[r / 3][c / 3][num] = true;
                board[r][c] = (char) (num + '1');

                // Recurse to the next cell
                backtrack(board, nextR, nextC);

                if (solved) return; // Stop if the puzzle is solved

                // Backtrack: remove the number
                board[r][c] = '.';
                rows[r][num] = false;
                cols[c][num] = false;
                blocks[r / 3][c / 3][num] = false;
            }
        }
    }
}
