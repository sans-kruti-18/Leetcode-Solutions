class Solution {
    public int totalFruit(int[] fruits) {
        int l=0;
        int ans=0;

        HashMap<Integer,Integer> mp=new HashMap<>();

        for(int r=0;r<fruits.length;r++)
        {
            mp.put(fruits[r],mp.getOrDefault(fruits[r],0)+1);

            if(mp.size()>2)
            {
                mp.put(fruits[l],mp.get(fruits[l])-1);

                if(mp.get(fruits[l])==0)
                 mp.remove(fruits[l]);

                l++;
            }

            ans=Math.max(ans,r-l+1);
        }

        return ans;
    }
}