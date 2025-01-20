class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        int n=arr.length;
        int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }
        if (totSum - target < 0 || (totSum - target) % 2 == 1)
            return 0;

        return findWays(arr, (totSum - target) / 2);
    }
    int findWays(int[] num, int tar) {
        int n = num.length;
        int prev[] = new int[tar + 1];
        if (num[0] == 0)
            prev[0] = 2;
        else
            prev[0] = 1;
        if (num[0] != 0 && num[0] <= tar)
            prev[num[0]] = 1;
        for (int ind = 1; ind < n; ind++) {
            int cur[] = new int[tar + 1];
            for (int target = 0; target <= tar; target++) {
                int notTaken = prev[target];

                int taken = 0;
                if (num[ind] <= target)
                    taken = prev[target - num[ind]];

                cur[target] = (notTaken + taken);
            }
            prev = cur;
        }

        return prev[tar];
    }
}