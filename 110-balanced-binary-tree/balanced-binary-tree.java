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
    private int height(TreeNode root, boolean[] res)
    {
        if(root==null) return 0;
        int lh=height(root.left, res);
        int rh=height(root.right, res);
        if(Math.abs(lh-rh)>1)
        res[0]=false;
        return 1+Math.max(rh,lh);
    }
    public boolean isBalanced(TreeNode root) {
        boolean[] res={true};
        height(root, res);
        return res[0];
    }
}