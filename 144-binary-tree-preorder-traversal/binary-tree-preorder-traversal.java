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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        TreeNode node = root;
        preorder(node, res);
        return res;
    }
    private void preorder(TreeNode node, List<Integer> result)
    {
        if(node==null) return;
        result.add(node.val);
        preorder(node.left, result);
        preorder(node.right, result);
    }
}