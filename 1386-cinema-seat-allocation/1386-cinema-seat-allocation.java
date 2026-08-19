class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            map.put(row, map.getOrDefault(row, 0) | (1 << col));
        }

        int leftMask  = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int midMask   = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int rightMask = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

        int ans = (n - map.size()) * 2;

        for (int rowMask : map.values()) {

            boolean leftFree = (rowMask & leftMask) == 0;
            boolean midFree = (rowMask & midMask) == 0;
            boolean rightFree = (rowMask & rightMask) == 0;

            if (leftFree && rightFree) {
                ans += 2;
            } else if (leftFree || midFree || rightFree) {
                ans += 1;
            }
        }

        return ans;
    }
}