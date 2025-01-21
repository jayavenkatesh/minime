class Solution {
    long[] dp;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new long[amount + 1];
        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0)
                dp[t] = 1;
            else {
                dp[t] =0;
            }
        }
        for (int i = 1; i < n; i++) {
            long[] cur=new long[amount+1];
            for (int t = 0; t <= amount; t++) {
                long notTake = dp[t];
                long take = 0;
                if (coins[i] <= t)
                    take =cur[t - coins[i]];

                cur[t] =notTake+take;
            }
            dp=cur;
        }
        long ans = dp[amount];
        return (int) ans;
    }
}