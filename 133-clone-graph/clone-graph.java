/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
        return null;
        Queue<Node> q=new LinkedList<>();
        HashMap<Node, Node> map=new HashMap<>();
        q.add(node);
        map.put(node, new Node(node.val));
        while(!q.isEmpty())
        {
            Node first=q.remove();
            Node firstclone=map.get(first);
            for(Node cur: first.neighbors)
            {
                Node curclone;
                if(map.containsKey(cur))
                {
                    curclone=map.get(cur);
                }
                else{
                    q.add(cur);
                    curclone=new Node(cur.val);
                    map.put(cur,curclone);
                }
                firstclone.neighbors.add(curclone);
            }
        }
        return map.get(node);
    }
}