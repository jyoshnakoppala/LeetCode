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
class Node{
    TreeNode node;
    int num;
    Node(TreeNode node, int num)
    {
        this.node=node;
        this.num=num;
    }

}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans=0;
        if(root==null) return ans;
        Queue<Node> q=new LinkedList<>();
        q.offer(new Node(root,0));
        while(!q.isEmpty()){
            int minnum=q.peek().num;
            int size =q.size();
            int first=0,last=0;
            for(int i=0;i<size;i++)
            {
                Node cur=q.poll();
                int curmin=cur.num-minnum;
                if(i==0) first=curmin;
                if(i==size-1) last=curmin;
                if(cur.node.left!=null)
                q.offer(new Node(cur.node.left, 2*curmin+1));
                if(cur.node.right!=null)
                q.offer(new Node(cur.node.right, 2*curmin+2));
            }
            ans=Math.max(ans, last-first+1);
        }
        return ans;
    }
}