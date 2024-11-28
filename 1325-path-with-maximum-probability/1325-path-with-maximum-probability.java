class Pair {
    int node;
    double weight;

    Pair(int n, double w) {
        this.node = n;
        this.weight = w;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i=0;i<edges.length;i++){
            int[] time=edges[i];
            adj.get(time[0]).add(new Pair(time[1], succProb[i]));
            adj.get(time[1]).add(new Pair(time[0], succProb[i]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.weight, a.weight));
        pq.add(new Pair(start_node, 1.0));
        double[] shortDist = new double[n];
        Arrays.fill(shortDist, 0.0);
        shortDist[start_node] = 1.0;
        boolean[] visited = new boolean[n];
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            double weight = current.weight;
            if (visited[node]) continue;
            visited[node] = true;
            for (Pair p : adj.get(node)) {
                int nn = p.node;
                double ew = p.weight;
                if (shortDist[node] * ew > shortDist[nn]) {
                    shortDist[nn] = shortDist[node] * ew;
                    pq.add(new Pair(nn, shortDist[nn]));
                }
            }
        }
        // int maxDelay = 0;
        // for (int i = 1; i <= n; i++) {
        //     if (shortDist[i] == Integer.MAX_VALUE) return -1;
        //     maxDelay = Math.max(maxDelay, shortDist[i]);
        // }

        // return maxDelay;
        return shortDist[end_node];
    }
}
