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

class NodeValue {
    int minNode;   // min value in subtree (if BST) – sentinel INT_MIN when invalid
    int maxNode;   // max value in subtree (if BST) – sentinel INT_MAX when invalid
    int subSum;    // sum of this subtree if it is a BST, 0 otherwise
    int bestSum;   // best BST-sum found anywhere in this subtree

    NodeValue(int minNode, int maxNode, int subSum, int bestSum) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.subSum  = subSum;
        this.bestSum = bestSum;
    }
}
class Solution {
    public int maxSumBST(TreeNode root) {
        NodeValue res=findans(root);
        return Math.max(res.bestSum,0);
    }
    private NodeValue findans(TreeNode root)
    {
        if(root==null)
        return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0);

        NodeValue left=findans(root.left);
        NodeValue right=findans(root.right);

        if(left.maxNode<root.val && root.val<right.minNode)
        {
        int cursum=root.val+left.subSum+right.subSum;
        int best=Math.max(cursum, Math.max(left.bestSum, right.bestSum));
        return new NodeValue(
            Math.min(root.val, left.minNode),
            Math.max(root.val, right.maxNode),
            cursum,
            best
        );
        }
        return new NodeValue(
                Integer.MIN_VALUE, Integer.MAX_VALUE,                
                0,                                                    
                Math.max(left.bestSum, right.bestSum)); 
    }
}