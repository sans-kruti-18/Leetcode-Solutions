class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;

        List<List<Integer>> rev=new ArrayList<>();
        for(int i=0;i<n;i++)
          rev.add(new ArrayList<>());

        int[] outDeg=new int[n];

        for(int u=0;u<n;u++)
        {
            for(int v:graph[u])
            {
                rev.get(v).add(u);
                outDeg[u]++;
            }
        }

        Queue<Integer> q= new LinkedList<>();
        List<Integer> safe=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            if(outDeg[i]==0)
             q.offer(i);
        }

        while(!q.isEmpty())
        {
            int node=q.poll();
            safe.add(node);

            for(int parent:rev.get(node))
            {
                outDeg[parent]--;
                if(outDeg[parent]==0)
                 q.offer(parent);
            }
        }

        Collections.sort(safe);

        return safe;


    }
}