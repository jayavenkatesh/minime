class Solution {
    int[][] dp;
    public int minimumTotal(List<List<Integer>> tri) {
        int n=tri.size();
        int m=tri.get(n-1).size();
        dp=new int[n][tri.get(n-1).size()];
        for(int j=0;j<m;j++){
            dp[n-1][j]=tri.get(n-1).get(j);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int down=tri.get(i).get(j)+dp[i+1][j];
                int dRight=tri.get(i).get(j)+dp[i+1][j+1];
                dp[i][j]=Math.min(down,dRight);
            }
        }
        return dp[0][0];
    }
}