class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int ans=0;
        int val=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]+1==nums[i+1]){
                val++;
            }
            else if(nums[i]==nums[i+1]){
                continue;
            }
            else{
                ans=Math.max(ans,val+1);
                val=0;
            }
        }
        ans=Math.max(ans,val+1);
        return ans;
    }
}