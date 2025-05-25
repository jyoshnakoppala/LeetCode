class Solution {
    public int repeatedStringMatch(String a, String b) {
         StringBuilder sb = new StringBuilder(a);
        int count = 1;

        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        if (kmpSearch(sb.toString(), b)) return count;

        sb.append(a);
        if (kmpSearch(sb.toString(), b)) return count + 1;

        return -1;
    }

    // KMP search function
    private boolean kmpSearch(String text, String pattern) {
        int[] lps = buildLPS(pattern);
        int i = 0, j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) return true;
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    // Build LPS (Longest Prefix Suffix) array
    private int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0, i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i++] = len;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }
        return lps;
    }
}