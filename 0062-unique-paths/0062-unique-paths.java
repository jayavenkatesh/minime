class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        for(int[] a:dp) Arrays.fill(a,-1);
        return rec(m-1,n-1);
    }
    int rec(int i,int j){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int left=rec(i,j-1);
        int right=rec(i-1,j);
        return dp[i][j] = left+right;
    }
}