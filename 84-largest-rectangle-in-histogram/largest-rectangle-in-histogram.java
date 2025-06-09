class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int maxarea=0;
        for(int i=0;i<heights.length;i++)
        {
          while(!st.isEmpty() && heights[st.peek()]>heights[i])
          {
            int ele = st.peek();
            st.pop();
            int nse = i, pse = st.isEmpty()?-1:st.peek();
            maxarea=Math.max(maxarea, heights[ele]*(nse-pse-1));

          }
          st.push(i);
        }
        while(!st.isEmpty())
        {
            int nse = heights.length;
            int element = st.peek();
            st.pop();
            int pse = st.isEmpty()?-1:st.peek();
            maxarea=Math.max(maxarea, heights[element]*(nse-pse-1));
        }
        return maxarea;
    }
}