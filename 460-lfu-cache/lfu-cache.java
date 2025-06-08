class LFUCache {

    class Node{
        int key, value, freq;
        Node(int key, int value){
            this.key=key;
            this.value=value;
            this.freq=1;
        }
    }
    private int capacity, minfreq;
    private Map<Integer, Node> keyNode;
    private Map<Integer, LinkedHashSet<Node>> freqList;



    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.minfreq=0;
        this.keyNode=new HashMap<>();
        this.freqList=new HashMap<>();
    }
    
    public int get(int key) {
        if(keyNode.containsKey(key)){
        Node node = keyNode.get(key);
        updateFreq(node);
        return node.value;
        }
        else 
        return -1;
    }
    
    public void put(int key, int value) {
        if(capacity==0) return;

        if(keyNode.containsKey(key))
        {
            Node node = keyNode.get(key);
            node.value=value;
            updateFreq(node);
        }
        else{
            if(keyNode.size()>=capacity)
            {
                LinkedHashSet<Node> minFreqList = freqList.get(minfreq);
                Node toremove=minFreqList.iterator().next();
                minFreqList.remove(toremove);
                keyNode.remove(toremove.key);
            }
            Node newnode=new Node(key, value);
            keyNode.put(key, newnode);
            freqList.computeIfAbsent(1, f -> new LinkedHashSet<>()).add(newnode);
            minfreq=1;
        }
    }
    private void updateFreq(Node node){
        int freq=node.freq;
        LinkedHashSet<Node> oldlist = freqList.get(freq);
        oldlist.remove(node);

        if(freq==minfreq && oldlist.isEmpty()){
            minfreq++;
        }
        node.freq++;
        freqList.computeIfAbsent(node.freq, f -> new LinkedHashSet<>()).add(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */