import java.util.*;

class DisjointSet {
    int[] parent, size;

    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findUPar(int node) {
        if (node == parent[node]) return node;
        return parent[node] = findUPar(parent[node]);
    }

    void unionBySize(int u, int v) {
        int pu = findUPar(u);
        int pv = findUPar(v);

        if (pu == pv) return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);

        Map<String, Integer> mailMap = new HashMap<>();

        // Step 1: Union accounts with common emails
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);

                if (!mailMap.containsKey(mail)) {
                    mailMap.put(mail, i);
                } else {
                    ds.unionBySize(i, mailMap.get(mail));
                }
            }
        }

        // Step 2: Group emails by parent
        List<String>[] merged = new ArrayList[n];
        for (int i = 0; i < n; i++) merged[i] = new ArrayList<>();

        for (String mail : mailMap.keySet()) {
            int parent = ds.findUPar(mailMap.get(mail));
            merged[parent].add(mail);
        }

        // Step 3: Build final result
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (merged[i].isEmpty()) continue;

            Collections.sort(merged[i]);

            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(merged[i]);

            result.add(temp);
        }

        return result;
    }
}
