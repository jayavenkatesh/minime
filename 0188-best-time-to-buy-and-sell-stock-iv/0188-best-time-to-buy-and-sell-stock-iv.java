class Solution {
    int[][][] dp;
    public int maxProfit(int k, int[] prices) {
        dp=new int[prices.length][2][k];
        for(int[][] arr:dp){
            for(int[] a:arr) Arrays.fill(a,-1);;
        }
        return rec(0,1,prices,0,k);
    }
    int rec(int i,int buy,int[] prices,int count,int k){
        if(count==k){
            return 0;
        }
        if(i>=prices.length) return 0;
        if(dp[i][buy][count]!=-1) return dp[i][buy][count];
        if(buy==1){
            return dp[i][buy][count]= Math.max(-prices[i]+rec(i+1,0,prices,count,k),rec(i+1,1,prices,count,k));
        }
        else{
            return dp[i][buy][count]= Math.max(prices[i]+rec(i+1,1,prices,count+1,k),rec(i+1,0,prices,count,k));
        }
    }
}