class Solution {
    public int maxIceCream(int[] $, int x) {
        Arrays.sort($);
        int i = 0;
        while (i < $.length && $[i] <= x)
            x -= $[i++];        
        return i;
    }
}