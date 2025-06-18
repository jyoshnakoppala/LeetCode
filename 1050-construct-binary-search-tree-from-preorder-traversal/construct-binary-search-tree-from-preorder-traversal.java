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
    public TreeNode bstFromPreorder(int[] preorder) {
        int bound=Integer.MAX_VALUE;
        return findans(preorder, bound, new int[]{0});
    }
    private TreeNode findans(int[] A, int bound, int[] i)
    {
       if(i[0]==A.length || A[i[0]]>bound) return null;
       TreeNode node=new TreeNode(A[i[0]++]);
       node.left=findans(A, node.val, i);
       node.right=findans(A, bound, i);
       return node;
    }
}