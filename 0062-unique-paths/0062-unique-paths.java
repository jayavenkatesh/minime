class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        dp[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) continue;
                int left=0;
                if(j>0) left=dp[i][j-1];
                int right=0;
                if(i>0) right=dp[i-1][j];
                dp[i][j] = left+right;
            }
        }
        return dp[m-1][n-1];
    }
}