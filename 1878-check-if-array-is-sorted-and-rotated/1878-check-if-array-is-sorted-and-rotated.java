class Solution {
    public boolean check(int[] nums) {
        int n=nums.length;
        while(n-->=0){
            rotate(nums);
            if(ifsorted(nums)){
                return true;
            }
        }
        return false;
    }
    boolean ifsorted(int[] nums){
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]) return false;
        }
        return true;
    }
    void rotate(int[] nums){
        for(int i=0;i<nums.length;i++){
            int temp=nums[i];
            nums[i]=nums[nums.length-1];
            nums[nums.length-1]=temp;
        }
    }
}