class Solution {
    public boolean isArraySpecial(int[] nums) {
        int i = 0;
        int t = i + 1;
        while (t < nums.length) {
            if (nums[i] % 2 == nums[t] % 2) {
                return false;
            }
            i++;
            t++;
        }
        return true;
    }
}