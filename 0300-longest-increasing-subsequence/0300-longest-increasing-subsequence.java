class Solution {
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        dp=new int[n+1];
        for(int i=n-1;i>=0;i--){
            int[] cur=new int[n+1];
            for(int prev=i-1;prev>=-1;prev--){
                int yepp=dp[prev+1];
                if(prev== -1 || nums[i]>nums[prev]){
                    yepp=Math.max(yepp,1+dp[i+1]);
                }
                cur[prev+1] = yepp;
            }
            dp=cur;
        }
        return dp[0];
    }
}