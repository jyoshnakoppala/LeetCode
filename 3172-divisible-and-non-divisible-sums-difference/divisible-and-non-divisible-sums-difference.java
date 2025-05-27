class Solution {
    public int differenceOfSums(int n, int m) {
        int div=0,notdiv=0;
        for(int i=1;i<=n;i++)
        {
            if(i%m!=0)
            notdiv+=i;
            else
            div+=i;      
              }
              return notdiv-div;
    }
}