/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        if(root==null)
         return new ArrayList<>();

        Map<TreeNode,TreeNode> parentMap=new HashMap<>();
        mapParent(root,parentMap);

        return bfs(target,parentMap,k);
    }

    private void mapParent(TreeNode root,Map<TreeNode,TreeNode> parentMap)
    {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            TreeNode node=q.poll();

            if(node.left!=null)
            {
                parentMap.put(node.left,node);
                q.offer(node.left);
            }
            if(node.right!=null)
            {
                parentMap.put(node.right,node);
                q.offer(node.right);
            }
        }
    }

    private List<Integer> bfs(TreeNode target,Map<TreeNode,TreeNode> parentMap,int k)
    {
        Queue<TreeNode> q= new LinkedList<>();
        Set<TreeNode> visited= new HashSet<>();
        q.offer(target);
        visited.add(target);

        int currLevel=0;

        while(!q.isEmpty())
        {
            int size=q.size();

            if(currLevel==k)
             break;

            currLevel++;

        for(int i=0;i<size;i++)
        {
            TreeNode node=q.poll();

            if(node.left!=null && !visited.contains(node.left))
            {
                visited.add(node.left);
                q.offer(node.left);
            }
            if(node.right!=null && !visited.contains(node.right))
            {
                visited.add(node.right);
                q.offer(node.right);
            }

            if(parentMap.containsKey(node) && !visited.contains(parentMap.get(node)))
            {
                visited.add(parentMap.get(node));
                q.offer(parentMap.get(node));
            }
        }
        }

        List<Integer> res=new ArrayList<>();

        while(!q.isEmpty())
         res.add(q.poll().val);

         return res;
    }
}