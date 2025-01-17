class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        int[][][] dp = new int[n][m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                dp[n - 1][i][j] = i==j?grid[n - 1][j]:grid[n-1][i]+grid[n-1][j];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 <m; j1++) {
                for (int j2 = 0; j2 <m; j2++) {
                    int ans = (int) -1e7;
                    for (int a = -1; a < 2; a++) {
                        for (int b = -1; b < 2; b++) {
                            int z = j1 == j2 ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                            if(j1+a>=0 && j2+b>=0 && j1+1<m && j2+b<m) {
                                z+=dp[i + 1][j1 + a][j2 + b];
                            }
                            else{
                                z+=(int) -1e7;
                            }
                            ans = Math.max(ans, z);
                        }
                    }
                    dp[i][j1][j2]=ans;
                }
            }
        }
        return dp[0][0][m-1];
    }
}