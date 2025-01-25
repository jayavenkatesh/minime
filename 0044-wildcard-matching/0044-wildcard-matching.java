class Solution {
    boolean[] dp;

    public boolean isMatch(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        dp = new boolean[m + 1];
        dp[0] = true;
        for (int j = 1; j <= m; j++) {
            if (s2.charAt(j - 1) == '*') {
                dp[j] = dp[j - 1];
            }
        }
        for (int i = 1; i <= n; i++) {
            boolean[] cur=new boolean[m+1];
            for (int j = 1; j <= m; j++) {
                if ((s1.charAt(i-1) == s2.charAt(j-1)) || s2.charAt(j-1) == '?') {
                    cur[j] = dp[j - 1];
                }
                else if(s2.charAt(j-1) == '*') {
                    cur[j] = cur[j - 1] || dp[j];
                }
                else{
                    cur[j] = false;
                }
            }
            dp=cur;
        }
        return dp[m];
    }
}