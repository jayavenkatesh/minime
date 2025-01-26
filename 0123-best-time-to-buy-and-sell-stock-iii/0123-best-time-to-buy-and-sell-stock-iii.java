class Solution {
    int[][][] dp;
    public int maxProfit(int[] prices) {
        dp=new int[prices.length][2][5];
        for(int[][] arr:dp){
            for(int[] a:arr) Arrays.fill(a,-1);;
        }
        return rec(0,1,prices,0);
    }
    int rec(int i,int buy,int[] prices,int count){
        if(count==2){
            return 0;
        }
        if(i>=prices.length) return 0;
        if(dp[i][buy][count]!=-1) return dp[i][buy][count];
        if(buy==1){
            return dp[i][buy][count]= Math.max(-prices[i]+rec(i+1,0,prices,count),rec(i+1,1,prices,count));
        }
        else{
            return dp[i][buy][count]= Math.max(prices[i]+rec(i+1,1,prices,count+1),rec(i+1,0,prices,count));
        }
    }
}