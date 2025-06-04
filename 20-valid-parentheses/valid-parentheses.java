class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<Character>();
        for(char c:s.toCharArray())
        {
            if(c=='(' || c=='{'|| c=='[')
            st.push(c);

            if(st.isEmpty())
            return false;

            if((c=='}' && st.pop()!='{')|| (c==')' && st.pop()!='(') || (c==']' && st.pop()!='['))
            return false;
        }
        return st.isEmpty();
    }
}