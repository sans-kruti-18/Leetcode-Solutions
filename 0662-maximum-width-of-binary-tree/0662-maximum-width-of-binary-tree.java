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
    
    static class Pair
    {
        TreeNode node;
        int index;

        Pair(TreeNode node,int index)
        {
            this.node=node;
            this.index=index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if(root==null)
         return 0;

        int maxiW=0;

        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));

        while(!q.isEmpty())
        {
            int size=q.size();
            int miniIndex=q.peek().index;
            int first=0,last=0;

            for(int i=0;i<size;i++)
            {
                Pair p=q.poll();
                TreeNode node=p.node;
                int currIndex=p.index-miniIndex;

                if(i==0)
                 first=currIndex;
                if(i==size-1)
                 last=currIndex;

                if(node.left!=null)
                 q.offer(new Pair(node.left,2*currIndex+1));
                if(node.right!=null)
                 q.offer(new Pair(node.right,2*currIndex+2));
            }

            maxiW= Math.max(maxiW,last-first+1);
        }

        return maxiW;

        
    }
}