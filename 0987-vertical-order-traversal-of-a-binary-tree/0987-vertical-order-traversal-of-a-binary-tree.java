/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    static class Tuple
    {
        TreeNode node;
        int vertical;
        int level;

        Tuple(TreeNode node, int vertical, int level)
        {
            this.node=node;
            this.vertical=vertical;
            this.level=level;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer , TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Tuple> q= new LinkedList<>();

        q.offer(new Tuple(root,0,0));

        while(!q.isEmpty())
        {
            Tuple t=q.poll();
            TreeNode curr=t.node;
            int x=t.vertical;
            int y=t.level;

            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());
            map.get(x).get(y).offer(curr.val);

            if(curr.left!=null)
             q.offer(new Tuple(curr.left,x-1,y+1));
            if(curr.right!=null)
             q.offer(new Tuple(curr.right,x+1,y+1));

        }

        List<List<Integer>> res= new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values())
        {
            List<Integer> col= new ArrayList<>();

            for(PriorityQueue<Integer> pq: ys.values())
            {
                while(!pq.isEmpty())
                 col.add(pq.poll());
            }
            res.add(col);
        }

        return res;
        
    }
}