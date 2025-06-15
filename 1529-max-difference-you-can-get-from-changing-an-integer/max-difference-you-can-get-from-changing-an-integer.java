class Solution {
    public int maxDiff(int num) {
        char ch=' ';
        char ch1=' ';
        String str=String.valueOf(num);
        int n=str.length();
        for(int i=0;i<n;i++)
        {
            if(str.charAt(i)!='9')
            {
            ch=str.charAt(i);
            break;
            }
        }
        String maxstr= (ch==' '?str:str.replace(ch, '9'));
        String minstr = str;
        for(int i=0;i<n;i++)
        {
            if (i==0 && str.charAt(i)!='1')
            {
                ch1=str.charAt(i);
                minstr= (ch1==' '?str:str.replace(ch1, '1'));
                break;
            }
            else if(i!=0 && str.charAt(i)!=str.charAt(0) && str.charAt(i)!='0')
            {
                ch1=str.charAt(i);
                minstr= (ch1==' '?str:str.replace(ch1, '0'));
                break;
            }
        }
        return Integer.parseInt(maxstr)-Integer.parseInt(minstr);
    }
}