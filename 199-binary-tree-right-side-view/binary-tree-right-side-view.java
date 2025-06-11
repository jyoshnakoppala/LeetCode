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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        int height=0;
        rightview(root, res, height);
        return res;
    }
    private void rightview(TreeNode root, List<Integer> res, int height)
    {
        if(root==null) return;
        if(height==res.size())
        res.add(root.val);
        rightview(root.right, res, height+1);
        rightview(root.left, res, height+1);
    }
}