class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long req=(long)m*k;
        if(req>bloomDay.length)
         return -1;

        int min=Arrays.stream(bloomDay).min().getAsInt();
        int max=Arrays.stream(bloomDay).max().getAsInt();

        int low=min,high=max,res=-1;

        while(low<=high)
        {
            int mid=(low+high)/2;

            if(isPoss(bloomDay,mid,m,k))
            {
                res=mid;
                high=mid-1;
            }
            else low=mid+1;
        }

        return res;
        
    }

    public boolean isPoss(int[] bloomDay,int day,int m,int k)
    {
        int cnt=0;
        int bqt=0;

        for(int bloom:bloomDay)
        {
            if(bloom<=day)
            {
                cnt++;
                if(cnt==k)
                {
                    bqt++;
                    cnt=0;
                }                
            }

            else
             cnt=0;
        }

        return bqt>=m;
    }
}