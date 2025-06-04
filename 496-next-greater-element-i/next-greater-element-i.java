class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums2.length;
        int[] nge=new int[n];
        Stack<Integer> st=new Stack<>();
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(nums2[i],i);
        }
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()<=nums2[i])
            st.pop();

            if(st.isEmpty())
            nge[i]=-1;
            else
            nge[i]=st.peek();

            st.push(nums2[i]);
        }
        int[] res=new int[nums1.length];
        for(int i=0;i<nums1.length;i++)
        {
            int index=map.get(nums1[i]);
            res[i]=nge[index];
        }
        return res;
    }
}