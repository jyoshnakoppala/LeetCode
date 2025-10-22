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
    public List<Integer> inorderTraversal(TreeNode root) {
       TreeNode temp=root;
       List<Integer> list=new ArrayList<Integer>();

       while(temp!=null)
       {
        if(temp.left==null)
        {
            list.add(temp.val);
            temp=temp.right;
        }
        else
        {
            TreeNode prev=temp.left;
            while(prev.right!=null && prev.right!=temp)
            {
                prev=prev.right;
            }
            if(prev.right==null)
            {
                prev.right=temp;
                temp=temp.left;
            }
            else
            {
                prev.right=null;
                list.add(temp.val);
                temp=temp.right;
            }
        }
       }
       return list;
    }
}