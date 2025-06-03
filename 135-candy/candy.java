class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int sum = 1; // First child gets 1 candy
        int i = 1;

        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                sum += 1;
                i++;
                continue;
            }

            // Count increasing slope
            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                sum += peak;
                i++;
            }

            // Count decreasing slope
            int down = 0;
            while (i < n && ratings[i] < ratings[i - 1]) {
                down++;
                sum += down;
                i++;
            }

            // Fix overlap at peak if down > peak
            if (down >= peak) {
                sum += (down - peak + 1);
            }
        }

        return sum;

    }
}