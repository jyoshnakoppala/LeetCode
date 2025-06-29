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
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return findans(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean findans(TreeNode root, long min, long max)
    {
        if(root==null) return true;
        if(root.val<=min || root.val>=max) return false;
        return (findans(root.left, min, root.val) && findans(root.right, root.val, max));
    }
}