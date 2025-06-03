class Solution {
    public int candy(int[] ratings) {
       int n = ratings.length;
        int[] left = new int[n];

        // Left to right pass
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        // Right to left pass using single variable
        int cur = 1;
        int sum = Math.max(left[n - 1], cur);  // Include last child's candy
        for (int j = n - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j + 1]) {
                cur += 1;
            } else {
                cur = 1;
            }
            sum += Math.max(left[j], cur);
        }

        return sum;
    }
}