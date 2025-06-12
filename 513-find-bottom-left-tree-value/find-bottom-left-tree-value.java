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
    int maxdepth, bottomvalue, level;
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode cur=root;
        q.add(cur);
        maxdepth=-1;bottomvalue=0;level=0;
        while(!q.isEmpty())
        {
            int sz=q.size();
            level++;
            for(int i=0;i<sz;i++)
            {
                cur=q.poll();
                if(maxdepth<level)
                {
                    maxdepth=level;
                    bottomvalue=cur.val;
                }
            if(cur.left!=null) q.add(cur.left);
            if(cur.right!=null) q.add(cur.right);
            }
        }
        return bottomvalue;
    }
}