class Solution {
    int[][] dp;
    public int minFallingPathSum(int[][] tri) {
        int n=tri.length;
        int m=tri[n-1].length;
        dp=new int[n][m];
        for(int j=0;j<m;j++){
            dp[n-1][j]=tri[n-1][j];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int down=tri[i][j]+dp[i+1][j];
                int dRight=Integer.MAX_VALUE;
                if(j<m-1) dRight=tri[i][j]+dp[i+1][j+1];
                int dLeft=Integer.MAX_VALUE;
                if(j>0) dLeft=tri[i][j]+dp[i+1][j-1];
                dp[i][j]=Math.min(down,Math.min(dRight,dLeft));
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<tri[0].length;i++){
            ans=Math.min(ans,dp[0][i]);
        }
        return ans;
    }
}