class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int n=(n1+n2);
        int ind2=n/2;
        int ind1=ind2-1;
        int ind1ele=-1;
        int ind2ele=-1;
        int i=0;int j=0;
        int count=0;

        while(i<n1 && j<n2)
        {
            if(nums1[i]<nums2[j])
            {
                if(count==ind1) ind1ele=nums1[i];
                if(count==ind2) ind2ele=nums1[i];
                count++;
                i++;
            }
            else
            {
                if(count==ind1) ind1ele=nums2[j];
                if(count==ind2) ind2ele=nums2[j];
                count++;
                j++;
            }
        }
        while(i<n1){
            if(count==ind1) ind1ele=nums1[i];
            if(count==ind2) ind2ele=nums1[i];
            count++;
            i++;
        }
        while(j<n2){
            if(count==ind1) ind1ele=nums2[j];
            if(count==ind2) ind2ele=nums2[j];
            count++;
            j++;
        }
         if (n % 2 == 0)
            return (ind1ele + ind2ele) / 2.0;
        else
            return ind2ele;
    }
}