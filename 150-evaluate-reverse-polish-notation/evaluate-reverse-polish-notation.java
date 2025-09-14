class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st=new Stack<>();
        for(String token:tokens)
        {
            if(isoperator(token))
            {
                int num2=Integer.parseInt(st.pop());
                int num1=Integer.parseInt(st.pop());
                int result=0;
                if(token.equals("+"))
                result=num1+num2;
                else if(token.equals("-"))
                result=num1-num2;
                else if(token.equals("/"))
                result=num1/num2;
                else if(token.equals("*"))
                result=num1*num2;

                st.push(Integer.toString(result));
            }
            else
            st.push(token);
        }
        return Integer.parseInt(st.peek());
    }
    private boolean isoperator(String s)
    {
        if(s.equals("+")|| s.equals("-")|| s.equals("*")||s.equals("/"))
        return true;
        else
        return false;
    }
}