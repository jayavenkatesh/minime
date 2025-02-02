class Solution {
    public int minCost(int N, int[] cuts) {
        int n = cuts.length + 2;
        int[] arr = new int[n];
        arr[0] = 0;
        arr[n - 1] = N;
        int z = 1;
        for (int i = 0; i < cuts.length; i++)
            arr[z++] = cuts[i];
        Arrays.sort(arr);
        int[][] dp = new int[n][n];
        for (int i = n-2; i >= 1; i--) {
            for (int j = 1; j <= n-2; j++) {
                if (i > j)
                    continue;
                int min = (int) 1e9;
                for (int k = i; k <= j; k++) {
                    int cutss = arr[j + 1] - arr[i - 1] + dp[i][k - 1] + dp[k + 1][j];
                    min = Math.min(min, cutss);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n-2];
    }
}