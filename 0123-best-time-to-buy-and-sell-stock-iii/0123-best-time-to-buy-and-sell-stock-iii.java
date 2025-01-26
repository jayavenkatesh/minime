class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        // for (int b = 0; b <= 1; b++) {
        //     for (int c = 0; c <= 2; c++) {
        //         dp[n][b][c] = 0;
        //     }
        // }
        for (int i = n - 1; i >= 0; i--) {
            for (int b = 0; b <= 1; b++) {
                for (int c = 0; c < 2; c++) {
                    if (b == 1) {
                        dp[i][b][c] = Math.max(-prices[i] + dp[i + 1][0][c], dp[i + 1][1][c]);
                    } else {
                        dp[i][b][c] = Math.max(prices[i] + dp[i + 1][1][c + 1], dp[i + 1][0][c]);
                    }
                }
            }
        }
        return dp[0][1][0];
    }
}
