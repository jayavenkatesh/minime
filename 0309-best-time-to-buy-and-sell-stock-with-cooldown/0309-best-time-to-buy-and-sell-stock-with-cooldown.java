class Solution {
    public int maxProfit(int[] p) {
        int n=p.length;
        int[][] dp=new int[n+1][2];
        dp[n][0]=dp[n][1]=0;
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                if(buy==1){
                    dp[i][buy] = Math.max(-p[i]+dp[i+1][0],dp[i+1][1]);
                }
                else{
                    if(i+2<=n-1) dp[i][buy] = Math.max(p[i]+dp[i+2][1],dp[i+1][0]);
                    else dp[i][buy] = Math.max(p[i]+dp[i+1][1],dp[i+1][0]);
                }
            }
        }
        return dp[0][1];
    }
}