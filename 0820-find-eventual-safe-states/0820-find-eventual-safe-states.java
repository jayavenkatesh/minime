class Solution {
    public List<Integer> eventualSafeNodes(int[][] adj) {
        int V=adj.length;
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        int check[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, adj, vis, pathVis, check);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (check[i] == 1)
                safeNodes.add(i);
        }
        return safeNodes;
    }
    boolean dfs(int node, int[][] adj, int vis[], 
    int pathVis[], int check[]) {
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;
        for (int it : adj[node]) {
            if (vis[it] == 0) {
                if (dfs(it, adj, vis, pathVis, check)) return true;
            }
            else if (pathVis[it] == 1) return true;
        }
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }
}