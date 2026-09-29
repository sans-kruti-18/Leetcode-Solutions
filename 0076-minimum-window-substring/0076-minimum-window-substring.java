class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> mp=new HashMap<>();

        int l=0;
        int cnt=0;

        int minLen=Integer.MAX_VALUE;
        int start=-1;

        for(char c: t.toCharArray())
         mp.put(c,mp.getOrDefault(c,0)+1);

        for(int r=0;r<s.length();r++)
        {
            char ch=s.charAt(r);

            if(mp.containsKey(ch))
            {
                mp.put(ch,mp.get(ch)-1);
                if(mp.get(ch) >= 0)
                 cnt++;
            }

            while(cnt == t.length())
            {
                if(r-l+1 < minLen)
                {
                    minLen=r-l+1;
                    start=l;
                }

                char left=s.charAt(l);

                if(mp.containsKey(left))
                {
                    mp.put(left,mp.get(left)+1);

                    if(mp.get(left)>0)
                     cnt--;
                }

                l++;
            }
        }

        return start == -1 ? "" : s.substring(start,start+minLen);
    }
}