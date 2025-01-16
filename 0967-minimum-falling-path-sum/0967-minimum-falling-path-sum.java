class Solution {
    int[] dp;
    public int minFallingPathSum(int[][] tri) {
        int n=tri.length;
        int m=tri[n-1].length;
        dp=new int[m];
        for(int j=0;j<m;j++){
            dp[j]=tri[n-1][j];
        }
        for(int i=n-2;i>=0;i--){
            int[] cur=new int[m];
            for(int j=m-1;j>=0;j--){
                int down=tri[i][j]+dp[j];
                int dRight=Integer.MAX_VALUE;
                if(j<m-1) dRight=tri[i][j]+dp[j+1];
                int dLeft=Integer.MAX_VALUE;
                if(j>0) dLeft=tri[i][j]+dp[j-1];
                cur[j]=Math.min(down,Math.min(dRight,dLeft));
            }
            dp=cur;
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<tri[0].length;i++){
            ans=Math.min(ans,dp[i]);
        }
        return ans;
    }
}