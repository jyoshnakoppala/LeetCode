class Solution {
    public int strStr(String haystack, String needle) {
       if (needle.length() == 0) return 0;

        // Combine pattern + '#' + text
        String combined = needle + "#" + haystack;
        int[] z = computeZArray(combined);
        int m = needle.length();

        // Look for full match of pattern in the Z-array
        for (int i = m + 1; i < z.length; i++) {
            if (z[i] == m) {
                return i - m - 1; // subtract pattern and '#' lengths
            }
        }

        return -1;
    }

    private int[] computeZArray(String s) {
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }

            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }

            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        return z;
    }
}