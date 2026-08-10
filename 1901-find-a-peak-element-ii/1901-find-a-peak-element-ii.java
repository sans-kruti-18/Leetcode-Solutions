class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int low=0,high=m-1;

        while(low<=high)
        {
            int mid_col=(low+high)/2;

            int row=maxEle(mat,mid_col);

            int left=mid_col-1>=0 ? mat[row][mid_col-1] : Integer.MIN_VALUE;
            int right= mid_col+1 <m ? mat[row][mid_col+1] : Integer.MIN_VALUE;

            if(mat[row][mid_col]>left && mat[row][mid_col]>right)
             return new int[]{row,mid_col};
            else if(mat[row][mid_col] < left)
             high=mid_col-1;
            else
             low=mid_col+1;
        }
        return new int[]{-1,-1};
    }

    public int maxEle(int[][] arr, int col) {
          int n = arr.length;
          int max = Integer.MIN_VALUE;
          int index = -1;
  
          for (int i = 0; i < n; i++) {
              if (arr[i][col] > max) {
                  max = arr[i][col];
                  index = i;
              }
          }
          return index;
      }


}