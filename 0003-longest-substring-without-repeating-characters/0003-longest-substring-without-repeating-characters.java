class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int l=0;
        int ans=0;
        HashMap<Character,Integer> mp=new HashMap<>();

        for(int r=0;r<n;r++)
        {
            char ch=s.charAt(r);

            if(mp.containsKey(ch))
              l=Math.max(l,mp.get(ch)+1);

            mp.put(ch,r);
            ans=Math.max(ans,r-l+1);
        }

        return ans;
    }
}