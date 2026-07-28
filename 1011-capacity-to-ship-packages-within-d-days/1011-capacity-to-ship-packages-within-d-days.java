class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxi=Integer.MIN_VALUE;
        int sum=0;

        for(int wt:weights)
        {
            maxi=Math.max(maxi,wt);
            sum += wt;
        }

        int low=maxi;
        int high=sum;

        while(low<=high)
        {
            int mid=(low+high)/2;
            
            int reqd= findDays(weights,mid);

            if(reqd <= days)
             high=mid-1;
            else 
             low=mid+1;
        }

        return low;

    }

    int findDays(int[] weights,int cap)
    {
        int days=1;
        int load=0;

        for(int wt:weights)
        {
            if(load + wt > cap)
            {
                days++;
                load= wt;
            }
            else
             load += wt;
        }

        return days;

    }
}