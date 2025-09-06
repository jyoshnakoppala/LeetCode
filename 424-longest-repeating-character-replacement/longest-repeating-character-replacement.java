class Solution {
    public int characterReplacement(String s, int k) {
        int maxlen = 0;
        int l = 0, maxfreq = 0;
        int[] hash = new int[26];

        for (int r = 0; r < s.length(); r++) {
            int idx = s.charAt(r) - 'A';
            hash[idx]++;
            maxfreq = Math.max(maxfreq, hash[idx]);

            while ((r - l + 1) - maxfreq > k) {
                hash[s.charAt(l) - 'A']--;
                l++;
            }

            maxlen = Math.max(maxlen, r - l + 1);
        }

        return maxlen;
    }
}