class Solution {
    public int longestNiceSubarray(int[] nums) {
        int ans = 1;
        int l = 0;
        int used = 0;  
        for (int r = 0; r < nums.length; r++) {
            while ((used & nums[r]) != 0) {
                used ^= nums[l++];
            } 
            used |= nums[r];
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}