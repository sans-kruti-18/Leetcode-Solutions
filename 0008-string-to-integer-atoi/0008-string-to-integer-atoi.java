class Solution {

    public int helper(String s, int i, int num, int sign) {

        if (i >= s.length() || !Character.isDigit(s.charAt(i)))
            return sign * num;

        int digit = s.charAt(i) - '0';

        if (num > Integer.MAX_VALUE / 10 ||
           (num == Integer.MAX_VALUE / 10 && digit > 7))
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        num = num * 10 + digit;

        return helper(s, i + 1, num, sign);
    }

    public int myAtoi(String s) {

        int i = 0;

        while (i < s.length() && s.charAt(i) == ' ')
            i++;

        int sign = 1;
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        return helper(s, i, 0, sign);
    }
}