class Solution {
    public int waysToSplitArray(int[] nums) {
        int ans=0;
        long lefts=nums[0];
        long rights=0;
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