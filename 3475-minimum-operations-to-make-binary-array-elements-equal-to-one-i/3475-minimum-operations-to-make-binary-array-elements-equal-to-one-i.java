class Solution {
    public int minOperations(int[] nums) {
        int cou=0;
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            if(nums[i]==1) continue;
            nums[i] ^=1;
            nums[i+1] ^=1;
            nums[i+2] ^=1;
            cou++;
        }
        return (nums[n-1]==1 && nums[n-2]==1)?cou:-1;
    }
}