class Solution {

    Map<String, List<String>> parentMap = new HashMap<>();
    Map<String, Integer> distance = new HashMap<>();
    List<List<String>> results = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return results;

        bfs(beginWord, endWord, dict);
        
        List<String> path = new ArrayList<>();
        path.add(endWord);
        dfs(endWord, beginWord, path);

        return results;
    }

    // ✅ BFS: build parent graph
    private void bfs(String beginWord, String endWord, Set<String> dict) {
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        distance.put(beginWord, 0);

        for (String word : dict)
            parentMap.put(word, new ArrayList<>());
        parentMap.put(beginWord, new ArrayList<>());

        while (!q.isEmpty()) {
            String word = q.poll();
            int currDist = distance.get(word);

            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char original = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == original) continue;
                    arr[i] = c;
                    String next = new String(arr);

                    if (dict.contains(next)) {
                        if (!distance.containsKey(next)) {
                            distance.put(next, currDist + 1);
                            parentMap.get(next).add(word);
                            q.offer(next);
                        } else if (distance.get(next) == currDist + 1) {
                            parentMap.get(next).add(word);
                        }
                    }
                }
                arr[i] = original;
            }
        }
    }

    // ✅ DFS: build paths
    private void dfs(String word, String beginWord, List<String> path) {
        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            results.add(temp);
            return;
        }

        for (String parent : parentMap.get(word)) {
            path.add(parent);
            dfs(parent, beginWord, path);
            path.remove(path.size() - 1);
        }
    }
}