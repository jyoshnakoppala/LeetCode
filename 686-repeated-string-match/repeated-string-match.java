class Solution {
    public int repeatedStringMatch(String a, String b) {
             int count = 1;
        StringBuilder temp = new StringBuilder(a);

        // Repeat 'a' until length of temp is at least that of b
        while (temp.length() < b.length()) {
            temp.append(a);
            count++;
        }

        // Check using Rabin-Karp
        if (containsRabinKarp(temp.toString(), b)) return count;

        // Try one more append in case b spans across boundaries
        temp.append(a);
        if (containsRabinKarp(temp.toString(), b)) return count + 1;

        return -1;
    }

    private boolean containsRabinKarp(String text, String pattern) {
        int base = 256;
        int mod = 1000000007;
        int n = text.length(), m = pattern.length();
        if (m > n) return false;

        long power = 1;
        for (int i = 0; i < m - 1; i++) {
            power = (power * base) % mod;
        }

        long patternHash = 0, textHash = 0;
        for (int i = 0; i < m; i++) {
            patternHash = (patternHash * base + pattern.charAt(i)) % mod;
            textHash = (textHash * base + text.charAt(i)) % mod;
        }

        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash) {
                if (text.substring(i, i + m).equals(pattern)) return true;
            }
            if (i < n - m) {
                textHash = (textHash - text.charAt(i) * power % mod + mod) % mod;
                textHash = (textHash * base + text.charAt(i + m)) % mod;
            }
        }

        return false;

    }
}