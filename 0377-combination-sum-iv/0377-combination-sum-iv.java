class Solution {
    int[][] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[nums.length+1][target + 1];
        for(int i=0;i<nums.length+1;i++) dp[i][0]=1;
        for(int i=1;i<nums.length+1;i++){
            for(int t=1;t<target+1;t++){
                int ways = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] <= t) ways += dp[nums.length - 1][t - nums[j]];
                }
                dp[i][t] = ways;
            }
        }
        return dp[nums.length][target];
    }
}