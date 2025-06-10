class StockSpanner {
    Stack<Pair<Integer, Integer>> st;
    int i;

    public StockSpanner() {
        st=new Stack<>();
        i = 0;
    }
    
    public int next(int price) {
        if(st.isEmpty())
        {
            st.push(new Pair<>(price, i));
            i++;
            return 1;
        }
        
            while(!st.isEmpty() && st.peek().getKey()<=price)
            {
            st.pop();
            }
            int top = st.isEmpty()?-1:st.peek().getValue();
            int span = i-top;

            st.push(new Pair<>(price, i));
            i++;
            return span;
    
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */