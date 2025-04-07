import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // Sort greed factors
        Arrays.sort(s); // Sort cookie sizes
        
        int child = 0;  // Pointer for children
        int cookie = 0; // Pointer for cookies
        
        while (child < g.length && cookie < s.length) {
            if (s[cookie] >= g[child]) {
                // Assign cookie to child
                child++;
            }
            // Move to next cookie either way
            cookie++;
        }
        
        return child; // Number of content children
    }
}
