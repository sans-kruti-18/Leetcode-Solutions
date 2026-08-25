class Solution {

    public int missingMultiple(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums)
            seen.add(num);
        
        int mult = k;
        while (seen.contains(mult)) 
            mult += k;
        
        return mult;
    }
}