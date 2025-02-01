class Solution {
    public int longestStrChain(String[] words) {
        int n=words.length;
        if(n==1) return 1;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] dp=new int[words.length];
        Arrays.fill(dp,1);
        int maxLen=0;
        for (int i = 1; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (compare(words[i],words[prev])) {
                    dp[i] = Math.max(dp[i], dp[prev] + 1);
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
            }
        }
        return maxLen;
    }
    boolean compare(String s1, String s2) {
        if (s1.length() != s2.length() + 1) {
            return false;
        }

        int first = 0;
        int second = 0;

        while (first < s1.length()) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }

        return first == s1.length() && second == s2.length();
    }
}