class Solution {
    public int beautySum(String s) {

        int n=s.length();
        int sum=0;

        for(int i=0;i<n;i++)
        {
            Map<Character,Integer> freq= new HashMap<>();

            for(int j=i;j<n;j++)
            {
                char ch=s.charAt(j);
                freq.put(ch,freq.getOrDefault(ch,0)+1);

                int mini=Integer.MAX_VALUE;
                int maxi=Integer.MIN_VALUE;

                for(int val:freq.values())
                {
                    mini=Math.min(mini,val);
                    maxi=Math.max(maxi,val);
                }

                sum += maxi-mini;
            }
         }

         return sum;
        
    }
}