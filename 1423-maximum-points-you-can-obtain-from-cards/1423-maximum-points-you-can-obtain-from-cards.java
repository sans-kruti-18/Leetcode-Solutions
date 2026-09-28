class Solution {
    public int maxScore(int[] card, int k) {
        int n=card.length;
        int lsum=0;
        int rsum=0;
        int maxSum=0;

        for(int i=0;i<k;i++)
         lsum += card[i];

        maxSum=lsum;

        int rind=n-1;
        for(int i=k-1;i>=0;i--)
        {
            lsum -= card[i];
            rsum += card[rind];
            rind--;

            maxSum = Math.max(maxSum,lsum+rsum);
        }

        return maxSum;
    }
}