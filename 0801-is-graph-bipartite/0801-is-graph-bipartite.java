class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] col = new int[n];
        Arrays.fill(col, -1);
        for (int i = 0; i < n; i++) {
            if (col[i] != -1) continue;
            Queue<Integer> queue = new LinkedList();
            queue.offer(i);
            col[i]=0;
            while (!queue.isEmpty()) {
                int a = queue.poll();
                for (int val : graph[a]) {
                    if (col[val] == -1) {
                        col[val]=1-col[a];
                        queue.offer(val);
                    } 
                    else if(col[a] == col[val]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}