class Solution {
    public void setZeroes(int[][] matrix) {

      int n = matrix.length;    // Number of rows
        int m = matrix[0].length; // Number of columns

        int[] col = new int[m]; // Column marker array
        int[] row = new int[n]; // Row marker array

        // Step 1: Identify rows and columns to be set to zero
        for (int i = 0; i < n; i++) {  // Loop through rows
            for (int j = 0; j < m; j++) {  // Loop through columns
                if (matrix[i][j] == 0) {
                    row[i] = 1;  // Mark row i
                    col[j] = 1;  // Mark column j
                }
            }
        }

        // Step 2: Modify matrix based on markers
        for (int i = 0; i < n; i++) {  // Loop through rows
            for (int j = 0; j < m; j++) {  // Loop through columns
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }

        // // Step 1: Traverse the matrix and mark the first row & column accordingly
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         if (matrix[i][j] == 0) {
        //             // Mark i-th row
        //             matrix[i][0] = 0;
        //             // Mark j-th column
        //             if (j != 0) {
        //                 matrix[0][j] = 0;
        //             } else {
        //                 col0 = 0;
        //             }
        //         }
        //     }
        // }

        // // Step 2: Mark cells with 0 from (1,1) to (n-1, m-1)
        // for (int i = 1; i < n; i++) {
        //     for (int j = 1; j < m; j++) {
        //         if (matrix[i][j] != 0) {
        //             if (matrix[i][0] == 0 || matrix[0][j] == 0) {
        //                 matrix[i][j] = 0;
        //             }
        //         }
        //     }
        // }

        // // Step 3: Mark the first row and first column
        // if (matrix[0][0] == 0) {
        //     for (int j = 0; j < m; j++) {
        //         matrix[0][j] = 0;
        //     }
        // }
        // if (col0 == 0) {
        //     for (int i = 0; i < n; i++) {
        //         matrix[i][0] = 0;
        //     }
        // }
        
    }
}