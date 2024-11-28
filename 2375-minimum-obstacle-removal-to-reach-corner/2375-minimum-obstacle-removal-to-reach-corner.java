class pair {
    int row;
    int col;
    int weight;

    pair(int row, int col, int w) {
        this.row = row;
        this.col = col;
        this.weight = w;
    }
}

class Solution {
    public int minimumObstacles(int[][] grid) {
        int[][] shortDist = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(shortDist[i], Integer.MAX_VALUE);
        }
        shortDist[0][0]=grid[0][0];

        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new pair(0, 0, grid[0][0]));
        int[] r = { -1, 0, 1, 0 };
        int[] c = { 0, 1, 0, -1 };
        while (!pq.isEmpty()) {
            pair p = pq.poll();
            for (int i = 0; i < r.length; i++) {
                int dr = p.row + r[i];
                int dc = p.col + c[i];

                if (dr >= 0 && dr < grid.length && dc >= 0 && dc < grid[0].length) {
                    if (shortDist[p.row][p.col] + grid[dr][dc] < shortDist[dr][dc]) {
                        shortDist[dr][dc] = shortDist[p.row][p.col] + grid[dr][dc];
                        pq.add(new pair(dr, dc, shortDist[dr][dc]));
                    }
                }
            }
        }
        return shortDist[grid.length - 1][grid[0].length - 1];
    }
}