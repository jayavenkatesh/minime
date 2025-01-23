class Solution {
    

    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] prev=new int[m+1];
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= m ; i++) prev[i] = 0;

        for (int i = 1; i < n + 1; i++) {
            int[] cur=new int[m+1];
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    cur[j]= 1 + prev[j - 1];
                }
                else cur[j] = Math.max(prev[j],cur[j - 1]);
            }
            prev=cur;
        }
        return prev[m];
    }
}