class Solution {
    public String reverseWords(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        // Remove leading spaces
        while (left <= right && s.charAt(left) == ' ') left++;
        // Remove trailing spaces
        while (left <= right && s.charAt(right) == ' ') right--;
        
        StringBuilder word = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        
        while (left <= right) {
            char ch = s.charAt(left);
            if (ch != ' ') {
                word.append(ch);
            } else if (word.length() != 0) {
                if (ans.length() != 0) ans.insert(0, ' ');
                ans.insert(0, word);
                word.setLength(0);
                
                // Skip spaces between words
                while (left + 1 <= right && s.charAt(left + 1) == ' ') left++;
            }
            left++;
        }
        
        // Append the last word
        if (word.length() != 0) {
            if (ans.length() != 0) ans.insert(0, ' ');
            ans.insert(0, word);
        }
        
        return ans.toString();
    }
}
