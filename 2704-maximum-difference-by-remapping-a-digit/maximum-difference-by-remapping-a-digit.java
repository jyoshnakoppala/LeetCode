class Solution {
    public int minMaxDifference(int num) {
        int diff=0;
        char ch=' ';
        String str=String.valueOf(num);
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)!='9')
            {
            ch=str.charAt(i);
            break;
            }
        }
        String dup="";
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)==ch)
            dup+='9';
            else
            dup+=str.charAt(i);
        }
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)!='0')
            {
            ch=str.charAt(i);
            break;
            }
        }
        String dup2="";
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)==ch)
            dup2+='0';
            else
            dup2+=str.charAt(i);
        }
        diff = Integer.valueOf(dup)-Integer.valueOf(dup2);
        return diff;
    }
}