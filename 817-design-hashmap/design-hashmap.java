class MyHashMap {
    private static final int SIZE=769;
    private final LinkedList<Node>[] buckets;
    public MyHashMap() {
        buckets=new LinkedList[SIZE];
    }
    
    public void put(int key, int value) {
        int i=key%SIZE;
        LinkedList<Node> bucket=buckets[i];
        if(bucket==null) 
        {
        buckets[i]=new LinkedList<>();
        buckets[i].add(new Node(key, value));
        return;
        }
        else
        {
            for(Node n:bucket)
            {
                if(n.key==key) 
                {
                n.value=value;
                return;
                }
            }
        }
        buckets[i].add(new Node(key, value));
    }
    
    public int get(int key) {
        int i=key%SIZE;
        LinkedList<Node> bucket=buckets[i];
        if(bucket==null) return -1;
        else
        {
            for(Node n:bucket)
            {
                if(n.key==key) return n.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int i=key%SIZE;
        LinkedList<Node> bucket=buckets[i];
        Node toremove=null;
        if(bucket==null) return;
        else
        {
            for(Node n:bucket)
            {
                if(n.key==key) toremove=n;
            }
            if(toremove!=null) bucket.remove(toremove);
        }
    }
}
class Node{
    int key;
    int value;
    Node(int key, int value)
    {
        this.key=key;
        this.value=value;
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */