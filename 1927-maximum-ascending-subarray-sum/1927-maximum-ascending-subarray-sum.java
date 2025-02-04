class Solution {
    public int maxAscendingSum(int[] nums) {
        int ans=0;
        int max=0;
        max=nums[0];
        ans=max;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                max+=nums[i];
                ans=Math.max(ans,max);
            }
            else{
                max=nums[i];
                ans=Math.max(ans,max);
            }
        }
        return ans;
    }
}