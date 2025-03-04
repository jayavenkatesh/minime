import java.util.*;

class Solution {
    private Map<String, Boolean> memo = new HashMap<>();
    public boolean checkPowersOfThree(int n) {
        return rec(n, 0, 0);
    }
    private boolean rec(int n, int k, int i) {
        if (n == k) return true;
        if (i >= 17 || k > n) return false;
        String key = k + "," + i;
        if (memo.containsKey(key)) return memo.get(key);

        int z = (int) Math.pow(3, i);
        boolean take = rec(n, k + z, i + 1);
        boolean notTake = rec(n, k, i + 1);

        memo.put(key, take || notTake);
        return memo.get(key);
    }
}
