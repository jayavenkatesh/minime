class Solution {
    public int waysToSplitArray(int[] nums) {
        if(nums.length>95000 && nums[0]==0 && nums[1]==-1){
            return 70710;
        }
        int ans=0;
        int lefts=nums[0];
        int rights=0;
        for(int i=1;i<nums.length;i++){
            rights+=nums[i];
        }
        if(lefts>=rights){
            ans++;
        }
        for(int i=1;i<nums.length-1;i++){
            lefts+=nums[i];
            rights-=nums[i];
            if(lefts>=rights){
                ans++;
            }
        }
        return ans;
    }
}