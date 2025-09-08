class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int minlen=Integer.MAX_VALUE;
        int start=-1;
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0;i<t.length();i++)
        {
            char ch=t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int l=0, r=0;
        int count=0;
        while(r<s.length())
        {
            char ch=s.charAt(r);
            if(map.containsKey(ch))
            {
                if(map.get(ch)>0)
                count++;
                map.put(ch, map.get(ch)-1);
            }
          while(count==t.length())
          {
            if(r-l+1<minlen)
            {
                minlen=r-l+1;
                start=l;
            }
            char leftchar=s.charAt(l);
            if(map.containsKey(leftchar))
            {
                map.put(leftchar, map.get(leftchar)+1);
                if(map.get(leftchar)>0) count--;
            }
            l++;
          }
          r++;
        }
        if (start == -1) return "";
        return s.substring(start, start+minlen);
    }
}