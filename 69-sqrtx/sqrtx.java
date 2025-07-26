class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        int ans=1;
        double low=1;
        double high=x;
        double eps=1e-6;
        while(high-low>eps)
        {
            double mid=(low+high)/2.0;
            if(mid*mid>x)
            high=mid;
            else
            low=mid;
        }
        return (int)high;
    }
}