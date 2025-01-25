class Solution {
    boolean[][] dp;

    public boolean isMatch(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int j = 1; j <= m; j++) {
            if (s2.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if ((s1.charAt(i-1) == s2.charAt(j-1)) || s2.charAt(j-1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if(s2.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
}