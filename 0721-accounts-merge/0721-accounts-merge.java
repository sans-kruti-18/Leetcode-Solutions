class Dis
{
    int[] parent,size;

    Dis(int n)
    {
        parent= new int[n];
        size=new int[n];

        for(int i=0;i<n;i++)
        {
            parent[i]=i;
            size[i]=1;
        }
    }

    int findUPar(int node)
    {
        if(node==parent[node])
         return node;

        return parent[node]=findUPar(parent[node]);
    }

    void union(int u,int v)
    {
        int pu=findUPar(u);
        int pv=findUPar(v);

        if(pu==pv)
         return;

        if(size[pu]<size[pv])
        {
            parent[pu]=pv;
            size[pv] += size[pu];
        }
        else
        {
            parent[pv]=pu;
            size[pu] += size[pv];
        }

    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> acc) {
        int n= acc.size();
        Dis ds= new Dis(n);

        Map<String,Integer> mailMap=new HashMap<>();

        for(int i=0;i<n;i++)
        {
            for(int j=1;j<acc.get(i).size();j++)
            {
                String mail=acc.get(i).get(j);

                if(!mailMap.containsKey(mail))
                  mailMap.put(mail,i);
                else
                  ds.union(i,mailMap.get(mail));
            }
        }

        List<String>[] merged= new ArrayList[n];
        for(int i=0;i<n;i++)
          merged[i]= new ArrayList<>();

        for(String mail:mailMap.keySet())
        {
            int parent=ds.findUPar(mailMap.get(mail));
            merged[parent].add(mail);
        }

        List<List<String>> res=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            if(merged[i].isEmpty())
             continue;

            Collections.sort(merged[i]);

            List<String> temp= new ArrayList<>();
            temp.add(acc.get(i).get(0));
            temp.addAll(merged[i]);

            res.add(temp);
        }

        return res;

    }
}