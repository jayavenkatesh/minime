class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[2][3];
        // for (int b = 0; b <= 1; b++) {
        //     for (int c = 0; c <= 2; c++) {
        //         dp[n][b][c] = 0;
        //     }
        // }
        for (int i = n - 1; i >= 0; i--) {
            int[][] cur=new int[2][3];;
            for (int b = 0; b <= 1; b++) {
                for (int c = 0; c < 2; c++) {
                    if (b == 1) {
                        cur[b][c] = Math.max(-prices[i] + dp[0][c], dp[1][c]);
                    } else {
                        cur[b][c] = Math.max(prices[i] + dp[1][c + 1], dp[0][c]);
                    }
                }
            }
            dp=cur;
        }
        return dp[1][0];
    }
}
