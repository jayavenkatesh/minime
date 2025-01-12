class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int a=fun(Arrays.copyOfRange(nums,1,nums.length));
        int b=fun(Arrays.copyOfRange(nums,0,nums.length-1));
        return Math.max(a,b);
        
    }
    int fun(int[] nums){
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=nums[1]>nums[0]?nums[1]:nums[0];
        for(int i=2;i<nums.length;i++){
            int pick=nums[i]+dp[i-2];
            int notPick=dp[i-1];
            dp[i]=Math.max(pick,notPick);
        }
        return dp[nums.length-1];
    }
}