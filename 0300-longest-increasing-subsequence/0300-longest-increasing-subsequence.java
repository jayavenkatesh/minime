class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=1;i<nums.length;i++){
            for(int prev=0;prev<=i;prev++){
                if(nums[i]>nums[prev]){
                    dp[i]=Math.max(dp[i],dp[prev]+1);
                }
            }
        }
        int ans=0;
        for(int i:dp) ans=Math.max(ans,i);
        return ans;
    }
}