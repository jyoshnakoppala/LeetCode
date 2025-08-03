class MyHashSet {

    private static final int SIZE = 769;              
    private final LinkedList<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[SIZE];
    }

    public void add(int key) { 
        int i=key%SIZE;
        if (buckets[i] == null) {
            buckets[i] = new LinkedList<>();
        }
        if (!buckets[i].contains(key)) {
            buckets[i].add(key);
        }
     }

    public void remove(int key) {
        int i=key%SIZE;
        LinkedList<Integer> list=buckets[i];
        int temp;
        if(list==null) return;
        list.remove(Integer.valueOf(key));
    }
    public boolean contains(int key) { 
        int i=key%SIZE;
        LinkedList<Integer> list=buckets[i];
        if(list==null) return false;;
        return list.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */