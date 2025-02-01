class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int[] dp = new int[n];
        int[] ind = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            ind[i] = i; 
        }

        int maxLen = 1, lastIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] % nums[prev] ==0 && dp[i] < dp[prev] + 1) {
                    dp[i] = dp[prev] + 1;
                    ind[i] = prev;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }
        ArrayList<Integer> lis = new ArrayList<>();
        while (ind[lastIndex] != lastIndex) {
            lis.add(nums[lastIndex]);
            lastIndex = ind[lastIndex];
        }
        lis.add(nums[lastIndex]);
        Collections.reverse(lis);
        return lis;
    }
}