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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> res=new LinkedList<List<Integer>>();
        q.add(root);

        while(!q.isEmpty())
        {
            List<Integer> sub=new LinkedList<>();
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode p=q.poll();
                if(p.left!=null) q.add(p.left);
                if(p.right!=null) q.add(p.right);
                sub.add(p.val);
            }
            res.add(sub);
        }
        return res;
    }
}