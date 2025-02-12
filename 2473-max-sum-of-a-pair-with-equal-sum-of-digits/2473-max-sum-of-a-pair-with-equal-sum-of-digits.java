class Solution {
    public int maximumSum(int[] nums) {
        int ans = -1;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            int sum = getDigitSum(num);
            if (hm.containsKey(sum)) {
                ans = Math.max(ans, num + hm.get(sum));
                hm.put(sum, Math.max(hm.get(sum), num)); 
            } else {
                hm.put(sum, num);
            }
        }
        return ans;
    }
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}