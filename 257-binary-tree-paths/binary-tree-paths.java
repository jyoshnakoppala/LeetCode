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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList<>();
        findans(root, "", result);
        return result;
    }
    private void findans(TreeNode root, String str, List<String> result)
    {
        if(root==null) return;

        str+=root.val;

        if(root.left==null && root.right==null)
        {
            result.add(str);
            return;
        }
        str+="->";
        findans(root.left, str, result);
        findans(root.right, str, result);
    }
}