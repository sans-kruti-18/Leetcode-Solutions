class Solution {
    public int numberOfSpecialChars(String word) {

        Set<Character> st= new HashSet<>();
        for(char ch : word.toCharArray())
        {
             st.add(ch);        

        }
        
        int cnt=0;

        for(char ch='a';ch<='z';ch++)
        {
            if(st.contains(ch) && st.contains((char)(ch - 'a' + 'A')))
             cnt++;
        }

        return cnt;
    }
}