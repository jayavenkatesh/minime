import java.util.*;

class Solution {
    List<List<Integer>> adj;
    boolean[] vis;
    int nodeCount, edgeCount; 

    public int countCompleteComponents(int n, int[][] edges) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int completeComponents = 0;
        vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                nodeCount = 0;
                edgeCount = 0;
                dfs(i);
                
                int expectedEdges = (nodeCount * (nodeCount - 1)) / 2;
                if (expectedEdges == edgeCount / 2) {
                    completeComponents++;
                }
            }
        }
        return completeComponents;
    }

    private void dfs(int node) {
        vis[node] = true;
        nodeCount++;

        for (int neighbor : adj.get(node)) {
            edgeCount++;
            if (!vis[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}
