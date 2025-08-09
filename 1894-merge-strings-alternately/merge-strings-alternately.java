class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int min=Math.min(m, n);
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<min;i++)
        {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        while(m-min>0)
        {
            sb.append(word1.charAt(min));
            min++;
        }while(n-min>0)
        {
            sb.append(word2.charAt(min));
            min++;
        }
        return sb.toString();
    }
}