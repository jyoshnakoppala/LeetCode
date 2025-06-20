/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      Queue<TreeNode> q=new LinkedList<>();
      StringBuilder s =new StringBuilder();
      q.offer(root);
      while(!q.isEmpty())
      {
        TreeNode temp=q.poll();
        if(temp==null)
        {
        s.append("n ");
        continue;
        }
        s.append(temp.val).append(" ");
        q.add(temp.left);
        q.add(temp.right);
      }
      return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         if (data.isEmpty() || data.startsWith("n")) return null;

    String[] res = data.split(" ");
    TreeNode root = new TreeNode(Integer.parseInt(res[0]));
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    int i = 1;
    while (!q.isEmpty() && i < res.length) {
        TreeNode parent = q.poll();

        if (!res[i].equals("n")) {
            TreeNode left = new TreeNode(Integer.parseInt(res[i]));
            parent.left = left;
            q.add(left);
        }
        i++;

        if (i < res.length && !res[i].equals("n")) {
            TreeNode right = new TreeNode(Integer.parseInt(res[i]));
            parent.right = right;
            q.add(right);
        }
        i++;
    }

    return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));