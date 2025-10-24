/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> arrayp=new ArrayList<>();
        ArrayList<TreeNode> arrayq=new ArrayList<>();

        findpath(root, p, arrayp);
        findpath(root, q, arrayq);

        int i=0;
        while(i<arrayp.size() && i<arrayq.size() && arrayp.get(i)==arrayq.get(i))
        {
            i++;
        }
        return arrayp.get(i-1);
    }
    private boolean findpath(TreeNode root, TreeNode find, List<TreeNode> res)
    {
        if(root==null) return false;

        res.add(root);

        if(root.val==find.val) return true;

        if(findpath(root.left, find, res)|| findpath(root.right, find, res))
        return true;

        res.remove(root);
        return false;
    }
}