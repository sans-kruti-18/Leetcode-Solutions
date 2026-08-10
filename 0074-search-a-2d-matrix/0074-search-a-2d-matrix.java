class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int n=arr.length;
        int m=arr[0].length;

        int low=0,high=n*m-1;

        while(low<=high)
        {
            int mid=(low+high)/2;

            int row=mid/m;
            int col=mid%m;

            if(arr[row][col]==target)
             return true;
            else if(arr[row][col]<target)
             low=mid+1;
            else
             high=mid-1;
        }
        return false;
    }
}