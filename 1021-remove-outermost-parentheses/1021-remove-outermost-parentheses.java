class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder res= new StringBuilder();
        int cnt=0;

        for(char ch : s.toCharArray())
        {
            if(ch=='(')
            {
                if(cnt>0)
                 res.append(ch);
                cnt++;
            }
            else if(ch==')')
            {
                cnt--;
                if(cnt>0)
                 res.append(ch);
            }
        }
        return res.toString();
        
    }
}