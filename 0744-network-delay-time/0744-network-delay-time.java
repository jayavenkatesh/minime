class Pair {
    int node;
    int weight;

    Pair(int n, int w) {
        this.node = n;
        this.weight = w;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] time : times) 
            adj.get(time[0]).add(new Pair(time[1], time[2]));
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Pair(k, 0));
        int[] shortDist = new int[n + 1];
        Arrays.fill(shortDist, Integer.MAX_VALUE);
        shortDist[k] = 0;
        boolean[] visited = new boolean[n + 1];
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int weight = current.weight;
            if (visited[node]) continue;
            visited[node] = true;
            for (Pair p : adj.get(node)) {
                int nn = p.node;
                int ew = p.weight;
                if (shortDist[node] + ew < shortDist[nn]) {
                    shortDist[nn] = shortDist[node] + ew;
                    pq.add(new Pair(nn, shortDist[nn]));
                }
            }
        }
        int maxDelay = 0;
        for (int i = 1; i <= n; i++) {
            if (shortDist[i] == Integer.MAX_VALUE) return -1;
            maxDelay = Math.max(maxDelay, shortDist[i]);
        }

        return maxDelay;
    }
}
