class Solution {
    int[] dp;
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        dp = new int[m + 1];
        dp[0]=1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = m; j >0; j--) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[j] = dp[j - 1]+dp[j];
                }
            }
        }
        return dp[m];
    }
}