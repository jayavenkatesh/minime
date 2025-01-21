class Solution {
    int[] dp;

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[amount + 1];
        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0)
                dp[t] = t / coins[0];
            else {
                dp[t] = (int) 1e9;
            }
        }
        for (int i = 1; i < n; i++) {
            int[] cur=new int[amount+1];
            for (int t = 1; t <= amount; t++) {
                int notTake = dp[t];
                int take = (int) 1e9;
                if (coins[i] <= t)
                    take = 1 + cur[t - coins[i]];

                cur[t] = Math.min(notTake, take);
            }
            dp=cur;
        }
        int ans = dp[amount];
        if(ans>=1e9) return -1;
        return ans;
    }
}