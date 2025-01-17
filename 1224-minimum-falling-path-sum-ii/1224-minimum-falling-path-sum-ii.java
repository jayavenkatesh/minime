class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[] dp = new int[n];
        for (int j = 0; j < n; j++) {
            dp[j] = grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            int[] cur = new int[n];
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, minIndex = -1;
            for (int j = 0; j < n; j++) {
                if (dp[j] < min1) {
                    min2 = min1;
                    min1 = dp[j];
                    minIndex = j;
                } else if (dp[j] < min2) {
                    min2 = dp[j];
                }
            }
            for (int j = 0; j < n; j++) {
                cur[j] = grid[i][j] + (j == minIndex ? min2 : min1);
            }
            dp = cur;
        }
        int ans = Integer.MAX_VALUE;
        for (int val : dp) {
            ans = Math.min(ans, val);
        }
        return ans;
    }
}
