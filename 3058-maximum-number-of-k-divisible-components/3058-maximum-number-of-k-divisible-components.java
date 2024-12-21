class Solution {
    static int ans;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList());
        }
        for (int[] arr : edges) {
            int a = arr[0];
            int b = arr[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        ans = 0;
        dfs(adj, values, 0, -1, k);

        return ans;

    }

    int dfs(List<List<Integer>> adj, int[] values, int cur, int parent, int k) {
        int val = values[cur];
        List<Integer> list = adj.get(cur);
        for (int i : list) {
            if (i != parent) {
                val += dfs(adj, values, i, cur, k);
            }
        }
        if (val % k == 0) {
            ans++;
            return 0;
        }
        return val%k;
    }
}