class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return mazeObstacles(obstacleGrid.length,obstacleGrid[0].length,obstacleGrid);
    }
    static int mazeObstacles(int n, int m, int[][] mat) {
        if(mat[0][0]==1) return 0;
        int[][] dp=new int[n][m];
		dp[0][0]=1;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(i==0 && j==0) continue;
                if(mat[i][j]==1) continue;
				int up=0;
				int left=0;
				if(i!=0) up=dp[i-1][j];
				if(j!=0) left=dp[i][j-1];
				dp[i][j]=up+left;
			}
		}
		return dp[n-1][m-1];
	}
}