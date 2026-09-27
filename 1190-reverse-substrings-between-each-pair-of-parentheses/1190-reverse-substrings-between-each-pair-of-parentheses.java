class Solution {

    public String reverseParentheses(String s) {
        Stack<Integer> openPareInd = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char curr : s.toCharArray()) {
            if (curr == '(') 
            {
                openPareInd.push(result.length());
            } 
            else if (curr == ')') 
            {
                int start = openPareInd.pop();
                reverse(result, start, result.length() - 1);
            }
             else 
                result.append(curr);
            
        }

        return result.toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, temp);
        }
    }
}