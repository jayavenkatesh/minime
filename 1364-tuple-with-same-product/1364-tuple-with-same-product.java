class Solution {
    public int tupleSameProduct(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int p = nums[i] * nums[j];
                if (hm.containsKey(p)) {
                    ans += 2 * hm.get(p); 
                }
                hm.put(p, hm.getOrDefault(p, 0) + 1);
            }
        }
        return ans * 4;
    }
}