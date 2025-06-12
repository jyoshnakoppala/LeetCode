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
    int maxdepth, bottomvalue;
    public int findBottomLeftValue(TreeNode root) {
        maxdepth=-1;bottomvalue=0;
        dfs(root,0);
        return bottomvalue;
    }
    private void dfs(TreeNode node, int level)
    {
        if(node==null) return;
        if(level>maxdepth)
        {
            maxdepth=level;
            bottomvalue=node.val;
        }
        dfs(node.left, level+1);
        dfs(node.right,level+1);
    }
}