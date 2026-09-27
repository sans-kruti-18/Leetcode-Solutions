class Solution {
    public int eraseOverlapIntervals(int[][] meets) {
        if(meets.length==0)
         return 0;

        Arrays.sort(meets,(a,b)->a[1]-b[1]);

        int remcnt=0;
        int lastEndTime=meets[0][1];

        for(int i=1;i<meets.length;i++)
        {
            if(meets[i][0]<lastEndTime)
             remcnt++;
            else
             lastEndTime=meets[i][1];
        }

        return remcnt;
    }
}