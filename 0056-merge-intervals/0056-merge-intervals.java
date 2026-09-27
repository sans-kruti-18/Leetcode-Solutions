class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        int ind=0;

        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0] <= intervals[ind][1])
             {
                intervals[ind][1]=Math.max(intervals[i][1],intervals[ind][1]);
             }
            else
            {
                ind++;
                intervals[ind]=intervals[i];
            }
        }

        return Arrays.copyOfRange(intervals,0,ind+1);
    }
}