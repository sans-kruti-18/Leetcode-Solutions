class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> row = new ArrayList<>();
        long prod = 1;
        row.add(1); // first element is always 1

        for (int j = 1; j <= rowIndex; j++) {
            prod = prod * (rowIndex - j + 1);
            prod = prod / j;
            row.add((int) prod);
        }

        return row;
    }
}