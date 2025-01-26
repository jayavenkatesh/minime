class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        dp=new int[n][n+1];
        for(int[] a:dp) Arrays.fill(a,-1);
        return rec(0,-1,nums);
    }
    int rec(int i,int prev,int[] nums){
        if(i>=nums.length) return 0;
        int take=0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        if(prev== -1 || nums[i]>nums[prev]){
            take=1+rec(i+1,i,nums);
        }
        int notTake=rec(i+1,prev,nums);
        return dp[i][prev+1] = Math.max(take,notTake);
    }
}