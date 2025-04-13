class Solution {
    final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long evenChoices = 5;
        long oddChoices = 4;
        long result = powerMod(evenChoices, (n + 1) / 2) * powerMod(oddChoices, n / 2) % MOD;
        
        return (int) result;
    }
    private long powerMod(long base, long exponent) {
        long result = 1;
        base %= MOD;
        
        while (exponent > 0) {
            if (exponent % 2 == 1)
                result = (result * base) % MOD;
            
            exponent >>= 1;
            base = (base * base) % MOD;
        }
        
        return result;
    }
}
