class Solution {
    public int repeatedStringMatch(String a, String b) {
    int count = 1;
        StringBuilder temp = new StringBuilder(a);

        // Repeat 'a' until its length is at least b's length
        while (temp.length() < b.length()) {
            temp.append(a);
            count++;
        }

        // Check if b is in current repeated string
        if (containsRabinKarp(temp.toString(), b)) return count;

        // Append one more time in case b overlaps the boundary
        temp.append(a);
        if (containsRabinKarp(temp.toString(), b)) return count + 1;

        return -1;
    }

    private boolean containsRabinKarp(String text, String pattern) {
        int base = 256;
        int mod = 1000000007;
        int n = text.length(), m = pattern.length();

        if (m > n) return false;

        long patternHash = 0, textHash = 0;
        long factor = 1;

        // Compute the hash of pattern and first window from right to left
        for (int i = m - 1; i >= 0; i--) {
            patternHash = (patternHash + (pattern.charAt(i) - 'a') * factor % mod) % mod;
            textHash = (textHash + (text.charAt(i) - 'a') * factor % mod) % mod;
            factor = (factor * base) % mod;
        }

        // Store the highest weight (base^(m-1)) for sliding hash
        long highestPower = 1;
        for (int i = 1; i < m; i++) {
            highestPower = (highestPower * base) % mod;
        }

        // Check all windows in text
        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash) {
                if (text.substring(i, i + m).equals(pattern)) {
                    return true;
                }
            }

            if (i < n - m) {
                // Remove leftmost character from hash
                textHash = (textHash - ((text.charAt(i) - 'a') * highestPower % mod) + mod) % mod;
                // Shift left and add next character
                textHash = (textHash * base + (text.charAt(i + m) - 'a')) % mod;
            }
        }

        return false;
    }
}