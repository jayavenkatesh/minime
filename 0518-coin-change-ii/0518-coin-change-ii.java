class Solution {
    long[][] dp;
    public int change(int amount, int[] coins) {
        dp=new long[coins.length][amount+1];
        for(long[] a:dp){
            Arrays.fill(a,-1);
        }
        return (int) rec(coins.length-1,coins,amount);
        
    }
    long rec(int i,int[] coins,int t){
        if(i==0){
            if(t%coins[0]==0) return 1;
            return 0;
        }
        if(dp[i][t]!=-1) return dp[i][t];
        long notTake=rec(i-1,coins,t);
        long take= 0;
        if(coins[i]<=t) take=rec(i,coins,t-coins[i]);

        return dp[i][t] = notTake+take;
    }
}