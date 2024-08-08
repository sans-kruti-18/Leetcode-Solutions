class Solution {
    public void reverseString(char[] s) {
        int n=s.length;
        int left=0;
        int right=n-1;
        while(left<right)
        {
            char ch=s[right];
            s[right]=s[left];
            s[left]=ch;
            left++;
            right--;            
        }
        
    }
}