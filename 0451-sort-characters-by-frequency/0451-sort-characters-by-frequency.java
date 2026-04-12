class Solution {

    public String frequencySort(String s) {

        // 1. Count frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // 2. Sort characters by frequency (descending)
        List<Character> chars = new ArrayList<>(freqMap.keySet());
        chars.sort((a, b) -> freqMap.get(b) - freqMap.get(a));

        // 3. Build result string
        StringBuilder res = new StringBuilder();
        for (char ch : chars) {
            int count = freqMap.get(ch);
            for (int i = 0; i < count; i++) {
                res.append(ch);
            }
        }

        return res.toString();
    }
}