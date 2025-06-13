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
    private boolean haspath(TreeNode node, int sum, int target)
    {
        if(node==null) return false;

        sum=sum+node.val;
        if(node.left == null && node.right == null && target==sum)
        return true;

        return (haspath(node.left,sum,target))||(haspath(node.right,sum,target));
    }
    public boolean hasPathSum(TreeNode root, int targetSum){
        int sum=0;
        boolean p= haspath(root, sum, targetSum);
        return p;
    }
}