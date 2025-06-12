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
    class Node{
        TreeNode node;
        int level;
        Node(TreeNode node, int level)
        {
            this.node=node;
            this.level=level;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(root, 0));
        TreeMap<Integer, List<Integer>> map=new TreeMap<>();
        while(!q.isEmpty())
        {
            Node p=q.poll();
            map.computeIfAbsent(p.level, k-> new ArrayList<>())
               .add(p.node.val);
            if(p.node.left!=null)
            q.add(new Node(p.node.left, p.level+1));
            if(p.node.right!=null)
            q.add(new Node(p.node.right, p.level+1));
        }
        return new ArrayList<>(map.values());
    }
}