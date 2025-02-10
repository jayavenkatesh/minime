class Pair {
    int node;
    long dist;
    Pair(int node, long dist) {
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    int mod = (int) 1e9 + 7;

    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] a : roads) {
            adj.get(a[0]).add(new int[]{a[1], a[2]});
            adj.get(a[1]).add(new int[]{a[0], a[2]});
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingLong(a -> a.dist));
        long[] dist = new long[n];
        int[] ways = new int[n];  
        Arrays.fill(dist, Long.MAX_VALUE);
        
        ways[0] = 1;
        dist[0] = 0;
        queue.offer(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            long d = p.dist;
            int node = p.node;
            if (d > dist[node]) continue;

            for (int[] a : adj.get(node)) {
                int nextNode = a[0];
                long edgeWeight = a[1];
                long newDist = d + edgeWeight;

                if (newDist < dist[nextNode]) {
                    ways[nextNode] = ways[node];
                    dist[nextNode] = newDist;
                    queue.offer(new Pair(nextNode, newDist));
                } else if (newDist == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1];
    }
}
