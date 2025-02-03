class Solution {
    public int uniquePathsWithObstacles(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        if(mat[0][0]==1) return 0;
        int[] dp=new int[m+1];
		dp[1]=1;
		for(int i=1;i<=n;i++){
            int[] cur=new int[m+1];
			for(int j=1;j<=m;j++){
				if(i==1 && j==1) {
                    cur[j]=1;
                    continue;
                }
                if(mat[i-1][j-1]==1){
                    cur[j]=0;
                    continue;
                }
				int up=dp[j];
				int left=cur[j-1];
				cur[j]=up+left;
			}
            dp=cur;
		}
		return dp[m];
    }
}