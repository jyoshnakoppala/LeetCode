class Solution {
    public String reverseWords(String s) {
        String reversed=new StringBuilder(s.trim()).reverse().toString();
        StringBuilder result=new StringBuilder();
        int i=0;
        int n=reversed.length();
            while(i<n)
            {
                while(i<n && reversed.charAt(i)==' ')
                i++;

                StringBuilder word=new StringBuilder();

                while(i<n && reversed.charAt(i)!=' ')
                {
                word.append(reversed.charAt(i));
                i++;
                }
                
                if(word.length()>0)
                result.append(word.reverse().toString()).append(" ");

            }
            return result.toString().trim();
    }
    }
