class Solution {
    int tim = 1;
    boolean[] vis;
    int[] ti;
    int[] low;
    List<List<Integer>> bridge;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (List<Integer> li : connections) {
            adj.get(li.get(0)).add(li.get(1));
            adj.get(li.get(1)).add(li.get(0));
        }
        
        vis = new boolean[n];
        ti = new int[n];
        low = new int[n];
        bridge = new ArrayList<>();
        
        dfs(0, -1, adj);
        return bridge;
    }

    void dfs(int i, int p, List<List<Integer>> adj) {
        vis[i] = true;
        ti[i] = low[i] = tim++;
        
        for (int a : adj.get(i)) {
            if (a == p) continue;
            
            if (vis[a]) {
                low[i] = Math.min(low[i], ti[a]); 
            } else {
                dfs(a, i, adj);
                low[i] = Math.min(low[i], low[a]);
                
                if (low[a] > ti[i]) {
                    bridge.add(Arrays.asList(i, a));
                }
            }
        }
    }
}
