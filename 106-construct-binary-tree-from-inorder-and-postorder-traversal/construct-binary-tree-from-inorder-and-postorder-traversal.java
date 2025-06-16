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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null || inorder.length!=postorder.length)
        return null;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        map.put(inorder[i],i);

        TreeNode root=findans(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, map);
        return root;
    }
    private TreeNode findans(int[] postorder, int poststart, int postend, int[] inorder, int instart, int inend, HashMap<Integer, Integer> map)
    {
        if(poststart>postend || instart>inend) return null;
        TreeNode root= new TreeNode(postorder[postend]);
        int inroot=map.get(root.val);
        int numleft=inroot-instart;

        root.left=findans(postorder, poststart, poststart+numleft-1, inorder, instart, inroot-1, map);
        root.right=findans(postorder, poststart+numleft, postend-1, inorder, inroot+1, inend, map);
        return root;
    }
}