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
public class BSTIterator
{
    private Stack<TreeNode> st=new Stack<TreeNode>();
    boolean reverse=false;//false-> next, true-> before
    public BSTIterator(TreeNode root, boolean reverse)
    {
        this.reverse=reverse;
        pushall(root);
    }
    public boolean hasnext()
    {
        return !st.isEmpty();
    }
    public int next()
    {
        TreeNode temp=st.pop();
        if(reverse==false)
        pushall(temp.right);
        else
        pushall(temp.left);
        return temp.val;
    }
    public void pushall(TreeNode root)
    {
        while(root!=null)
        {
        st.push(root);
        if(reverse==false)
            root=root.left;
        else
            root=root.right;
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        BSTIterator l=new BSTIterator(root, false);
        BSTIterator r=new BSTIterator(root, true);

        int i=l.next();
        int j=r.next();

        while(i<j)
        {
            if(i+j==k) return true;
            else if(i+j<k) i=l.next();
            else j=r.next();
        }
        return false;
    }
}