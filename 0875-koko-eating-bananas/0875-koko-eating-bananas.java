class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = Arrays.stream(piles).max().getAsInt();
        int low=1;
        int high=maxPile;
        int ans=maxPile;

        while(low<=high)
        {
            int mid=(low+high)/2;

            long total=calc(piles,mid);

            if(total<=h)
            {
                ans=mid;
                high=mid-1;
            }
            else
             low=mid+1;
        }
        return ans;
        
    }

    private long calc(int[] piles,int speed)
    {
        long total=0;

        for(int bananas:piles)
        {
            total += (long)Math.ceil((double)bananas/speed);
        }
        return total;
    }
}