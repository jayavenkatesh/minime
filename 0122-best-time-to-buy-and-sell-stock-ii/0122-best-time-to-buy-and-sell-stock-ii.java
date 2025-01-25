class Solution {
    int[] dp;
    public int maxProfit(int[] p) {
        int n=p.length;
        dp=new int[2];
        dp[0]=dp[1]=0;
        for(int i=n-1;i>=0;i--){
            int[] cur=new int[2];
            for(int buy=0;buy<=1;buy++){
                if(buy==1){
                    cur[buy] = Math.max(-p[i]+dp[0],dp[1]);
                }
                else{
                    cur[buy] = Math.max(p[i]+dp[1],dp[0]);
                }
            }
            dp=cur;
        }
        return dp[1];
    }
}