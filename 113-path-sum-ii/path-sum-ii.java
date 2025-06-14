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
    private void getans(TreeNode node, int targetsum, List<List<Integer>> res, List<Integer> in)
    {
        if(node==null) return;

        targetsum-=node.val;
        in.add(node.val);

        if(node.left==null && node.right==null && targetsum==0)
        {
        res.add(new ArrayList<>(in));
        }
        else
        {
        getans(node.left, targetsum, res, in);
        getans(node.right, targetsum, res, in);
        }
      in.remove(in.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> in=new ArrayList<>();
        getans(root, targetSum, res, in);
        return res;
    }
}