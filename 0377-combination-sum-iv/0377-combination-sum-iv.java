class Solution {
    int[][] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[nums.length][target + 1];
        for (int[] a : dp) Arrays.fill(a, -1);
        return rec(nums.length - 1, nums, target);
    }
    int rec(int i, int[] nums, int t) {
        if (t == 0) return 1;
        if (i < 0) return 0;
        if (dp[i][t] != -1) return dp[i][t];
        int ways = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] <= t) ways += rec(nums.length - 1, nums, t - nums[j]);
        }
        return dp[i][t] = ways;
    }
}