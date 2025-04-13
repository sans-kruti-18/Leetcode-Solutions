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
    private void inorder(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        inorder(root.left, arr);       // Traverse left subtree
        arr.add(root.val);            // Visit current node
        inorder(root.right, arr);     // Traverse right subtree
    }

    // Public method to be called
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);         // Perform inorder traversal
        return result;                 // Return the result
    }
}