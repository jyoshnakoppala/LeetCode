class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int maxi=Integer.MIN_VALUE;
        while(i<j)
        {
            maxi=Math.max(maxi, (j-i)*Math.min(height[i], height[j]));
            if(height[i]<height[j])
            i++;
            else
            j--;
        }
        return maxi;

    }
}