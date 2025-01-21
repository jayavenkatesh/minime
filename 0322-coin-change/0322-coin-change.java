class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp=new int[coins.length][amount+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        int ans= rec(coins.length-1,coins,amount);
        if(ans>=1e9) return -1;
        return ans;
    }
    int rec(int i,int[] coins,int t){
        if(t==0){
            return 0;
        }
        if(i==0){
            if(t%coins[i]==0) return t/coins[i];
            return (int) 1e9;
        }
        if(dp[i][t]!=-1) return dp[i][t];
        int notTake=rec(i-1,coins,t);
        int take= (int) 1e9;
        if(coins[i]<=t) take=1+rec(i,coins,t-coins[i]);

        return dp[i][t] = Math.min(notTake,take);
    }
}