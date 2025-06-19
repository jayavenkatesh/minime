class Solution {
    public int partitionArray(int[] nums, int k) {
        int n=0;
        Arrays.sort(nums);
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]-nums[i]>k){
                n++;
                i=j;
            }
        }
        return n+1;
    }
}