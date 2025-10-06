class TimeMap {
    private static class Pair{
        String value;
        int timestamp;
        Pair(int timestamp, String value)
        {
            this.value=value;
            this.timestamp=timestamp;
        }
    }
    private Map<String, ArrayList<Pair>> map;

    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key))
        map.put(key, new ArrayList<>());

        ArrayList<Pair> list=map.get(key);
        list.add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        ArrayList<Pair> list=map.get(key);
        int low=0, high=list.size()-1;
        String result="";

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(list.get(mid).timestamp<=timestamp)
            {
                result=list.get(mid).value;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */