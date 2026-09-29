class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> mp=new HashMap<>();
        int l=0;
        int ans=0;
        int maxFreq=0;

        for(int r=0;r<s.length();r++)
        {
            char ch=s.charAt(r);

            mp.put(ch,mp.getOrDefault(ch,0)+1);
            maxFreq=Math.max(maxFreq,mp.get(ch));

            while((r-l+1)-maxFreq > k)
            {
                char left=s.charAt(l);

                mp.put(left,mp.get(left)-1);
                if(mp.get(left)==0)
                 mp.remove(left);

                maxFreq=0;
                for(int freq:mp.values())
                 maxFreq=Math.max(maxFreq,freq);

                l++;
            }

            ans=Math.max(ans,r-l+1);
        }

        return ans;
    }
}