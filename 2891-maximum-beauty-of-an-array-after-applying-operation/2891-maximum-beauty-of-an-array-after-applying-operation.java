class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int ans=0;
        int l=0;
        Arrays.sort(nums);
        int val=0;
        for(int r=0;r<nums.length;r++){
            while(l<nums.length && nums[r]-k>nums[l]+k){
                val--;
                l++;
            }
            if(l<nums.length && nums[r]-k<=nums[l]+k){
                val++;
            }
            ans=Math.max(ans,val);
        }
        return ans;
    }
}