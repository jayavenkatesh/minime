class Solution {
    public int dominantIndex(int[] nums) {
        int large=0;
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]>large){
                large=nums[j];
                i=j;
            }
        }
        for(int j:nums){
            if(j!=large && j*2>large){
                return -1;
            }
        }
        return i;
    }
}