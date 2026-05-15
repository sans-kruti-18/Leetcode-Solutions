class Solution {
    public int removeStones(int[][] stones) {

    Map<Integer, Integer> parent = new HashMap<>();

    int offset = 10001;

    for (int[] stone : stones) {
        union(parent, stone[0], stone[1] + offset);
    }

    Set<Integer> components = new HashSet<>();

    for (int[] stone : stones) {
        components.add(find(parent, stone[0]));
    }

    return stones.length - components.size();
}

private int find(Map<Integer, Integer> parent, int x) {
    parent.putIfAbsent(x, x);

    if (!parent.get(x).equals(x)) {
        parent.put(x, find(parent, parent.get(x)));
    }
    return parent.get(x);
}

private void union(Map<Integer, Integer> parent, int x, int y) {
    int px = find(parent, x);
    int py = find(parent, y);

    if (px != py) {
        parent.put(px, py);
    }
}
}