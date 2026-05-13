class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
          adj.add(new ArrayList<>());

        for(int[] flight: flights)
        {
            adj.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }

        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{0,src,0});

        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        while(!q.isEmpty())
        {
            int[] curr=q.poll();
            int stops=curr[0];
            int node=curr[1];
            int cost=curr[2];

            if(stops>k)
             continue;

            for(int[] adjNode: adj.get(node))
            {
                int next=adjNode[0];
                int nextCost = adjNode[1];

                if(cost+nextCost< dist[next] && stops<=k)
                {
                    dist[next]=cost+nextCost;
                    q.offer(new int[]{stops+1,next,dist[next]});
                }
            }
        }

        if(dist[dst]==Integer.MAX_VALUE)
         return -1;

        return dist[dst];

        
    }
}