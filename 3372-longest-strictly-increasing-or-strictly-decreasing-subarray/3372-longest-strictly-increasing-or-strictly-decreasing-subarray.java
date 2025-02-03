class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1, dec = 1;
        int maxInc = 1, maxDec = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++; 
                maxInc = Math.max(maxInc, inc);
                dec = 1;
            } else {
                inc = 1;
            }
            
            if (nums[i] < nums[i - 1]) {
                dec++;
                maxDec = Math.max(maxDec, dec);
                inc = 1;
            } else {
                dec = 1;
            }
        }
        return Math.max(maxInc, maxDec);
    }
}
