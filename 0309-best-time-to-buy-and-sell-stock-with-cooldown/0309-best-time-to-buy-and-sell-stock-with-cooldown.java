class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        int n=prices.length;
        dp=new int[n][2];
        for(int[] a:dp) Arrays.fill(a,-1); 
        return rec(0,1,prices);
    }
    int rec(int i,int buy,int[] p){
        if(i>p.length-1) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==1){
            return dp[i][buy] = Math.max(-p[i]+rec(i+1,0,p),rec(i+1,1,p));
        }
        else{
            return dp[i][buy] = Math.max(p[i]+rec(i+2,1,p),rec(i+1,0,p));
        }
    }
}