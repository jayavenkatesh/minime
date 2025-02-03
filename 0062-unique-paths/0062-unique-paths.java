class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp=new int[m+1][n+1];
        dp[1][1]=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1 && j==1) continue;
                int left=dp[i][j-1];
                int right=dp[i-1][j];
                dp[i][j] = left+right;
            }
        }
        return dp[m][n];
    }
}