class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == ',' ) continue;

            if (ch != ')') {
                st.push(ch);
            } else {
                int t = 0, f = 0;

                while (st.peek() != '(') {
                    char c = st.pop();
                    if (c == 't') t++;
                    else if (c == 'f') f++;
                }

                st.pop(); // remove '('
                char op = st.pop();

                if (op == '&') {
                    st.push(f == 0 ? 't' : 'f');
                } 
                else if (op == '|') {
                    st.push(t > 0 ? 't' : 'f');
                } 
                else { // !
                    st.push(f == 1 ? 't' : 'f');
                }
            }
        }

        return st.peek() == 't';
    }
}