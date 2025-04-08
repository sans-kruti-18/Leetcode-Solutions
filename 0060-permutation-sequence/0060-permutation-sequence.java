class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int[] fact = new int[n];
        fact[0] = 1;

        // Build the list [1, 2, ..., n] and factorials
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        k--; // Convert to 0-indexed
        StringBuilder result = new StringBuilder();

        for (int i = n; i >= 1; i--) {
            int index = k / fact[i - 1];
            result.append(nums.get(index));
            nums.remove(index);
            k %= fact[i - 1];
        }

        return result.toString();
    }
}
