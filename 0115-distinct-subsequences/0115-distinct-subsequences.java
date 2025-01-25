class Solution {
    int[] dp;
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        dp = new int[m + 1];
        dp[0]=1;
        for (int i = 1; i < n + 1; i++) {
            int[] cur=new int[m+1];
            cur[0]=1;
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    cur[j] = dp[j - 1]+dp[j];
                }
                else cur[j] = dp[j];
            }
            dp=cur;
        }
        return dp[m];
    }
}