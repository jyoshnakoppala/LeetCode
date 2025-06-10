class MinStack {
    Stack<Long> st;
    long min = Long.MAX_VALUE;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        long v = val;
        if(st.isEmpty())
        {
        st.push(v);
        min=v;
        }
        else
        {
            if(v<min)
            {
                long newval=2*v-min;
                min = v;
                st.push(newval);
            }
            else
            st.push(v);
        }
    }
    
    public void pop() {
        if(st.isEmpty())
        return;

        long n=st.peek();
        st.pop();

        if(n<min)
        min = 2 * min - n;
    }
    
    public int top() {
        long v=st.peek();
        if(v<min)
        return (int) min;

        return (int) v;
    }
    
    public int getMin() {
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */