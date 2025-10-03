class FreqStack {
        Map<Integer, Integer> freqmap;
        Map<Integer, Stack<Integer>> freqst;
        int maxfreq;
    public FreqStack() {
        freqmap=new HashMap<>();
        freqst=new HashMap<>();
        maxfreq=0;
    }
    public void push(int val) {
        int freq=freqmap.getOrDefault(val, 0)+1;
        freqmap.put(val, freq);
        if(freq>maxfreq)
        maxfreq=freq;
        if(!freqst.containsKey(freq))
        freqst.put(freq, new Stack<>());
        freqst.get(freq).push(val);
    }
    
    public int pop() {
         int val = freqst.get(maxfreq).pop(); 
         freqmap.put(val, freqmap.get(val)-1);

         if(freqst.get(maxfreq).isEmpty())
         maxfreq--;

         return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */