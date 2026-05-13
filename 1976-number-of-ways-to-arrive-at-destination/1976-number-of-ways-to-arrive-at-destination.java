class Solution {
    public int countPaths(int n, int[][] roads) {
        
        List<List<int[]>> adj= new ArrayList<>();
        for(int i=0;i<n;i++)
          adj.add(new ArrayList<>());

        for(int[] road: roads)
        {
            int u=road[0];
            int v=road[1];
            int wt= road[2];

            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});

        }

        long[] dist=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);

        int mod=(int)(1e9+7);

        int[] ways=new int[n];

        dist[0]=0;
        ways[0]=1;

        PriorityQueue<long[]> pq= new PriorityQueue<>(Comparator.comparingLong(a->a[0]));
        pq.add(new long[]{0,0});

        while(!pq.isEmpty())
        {
            long[] curr=pq.poll();
            long d=curr[0];
            int node=(int)curr[1];

            if(dist[node]<d)
              continue;

            for(int[] edge: adj.get(node))
            {
                int next=edge[0];
                long wt=edge[1];

                long newDist = d+wt;

                if(newDist<dist[next])
                {
                    dist[next]=newDist;
                    ways[next]= ways[node];
                    pq.offer(new long[]{dist[next],next});
                }

                else if(newDist == dist[next])
                  ways[next]= (ways[next] + ways[node])%mod;
            }
        }

        return ways[n-1]%mod;
    }
}