class Solution {
    public boolean isArraySpecial(int[] nums) {
        int t =1;
        while (t < nums.length) {
            if (nums[t-1] % 2 == nums[t] % 2) {
                return false;
            }
            t++;
        }
        return true;
    }
}