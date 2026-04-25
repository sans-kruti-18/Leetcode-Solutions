class Solution {
    public boolean validDigit(int n, int x) {
        String s = String.valueOf(n);
        char target = (char) ('0' + x);

        
        if (s.charAt(0) == target) {
            return false;
        }

        
        return s.indexOf(target) != -1;
    }
}