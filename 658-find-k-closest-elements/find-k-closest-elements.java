class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i=0;
        int j=k-1;
        int sum=0;
        int ans=Integer.MAX_VALUE;
        int start=0;
        int end=0;
        ArrayList<Integer> finalans=new ArrayList<>();
        while(j<arr.length)
        {
            for(int ind=i;ind<=j;ind++)
            {
                sum+=Math.abs(x-arr[ind]);
            }
            if(sum<ans)
            {
                ans=sum;
                start=i;
                end=j;
            }
            sum=0;
            i++;
            j++;
        }
        for(int l=start;l<=end;l++)
        {
            finalans.add(arr[l]);
        }
        return finalans;
    }
}