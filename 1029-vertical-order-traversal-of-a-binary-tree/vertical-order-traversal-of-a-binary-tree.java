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
        int col, level;
        Node(TreeNode node, int col, int level)
        {
            this.node=node;
            this.col=col;
            this.level=level;
        }
        
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0, 0));
        while(!q.isEmpty())
        {
            Node node1=q.remove();
            TreeNode n=node1.node;
            int col=node1.col;
            int row=node1.level;

            map.computeIfAbsent(col, k-> new TreeMap<>())
               .computeIfAbsent(row, k-> new PriorityQueue<>())
               .add(n.val);

            if(n.left!=null)
            q.add(new Node(n.left, col-1, row+1));

            if(n.right!=null)
            q.add(new Node(n.right, col+1, row+1));

        }
        List<List<Integer>> res=new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> col: map.values())
        {
            List<Integer> cols=new ArrayList<>();
            for(PriorityQueue<Integer> p : col.values())
            {
                while(!p.isEmpty())
                cols.add(p.remove());
            }
            res.add(cols);
        }
        return res;
    }
}