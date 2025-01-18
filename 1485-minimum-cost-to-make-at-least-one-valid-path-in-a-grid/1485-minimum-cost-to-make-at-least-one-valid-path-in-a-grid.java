class Pair {
    int row, col, cost;

    Pair(int row, int col, int cost) {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }
}

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] shortDist = new int[m][n];
        for (int[] row : shortDist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        shortDist[0][0] = 0;
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Pair(0, 0, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int r = p.row, c = p.col, cost = p.cost;
            if (r == m - 1 && c == n - 1) {
                return cost;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                int newCost = cost;
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    if (grid[r][c] == i + 1) {
                        newCost = cost;
                    } else {
                        newCost = cost + 1;
                    }
                    if (newCost < shortDist[nr][nc]) {
                        shortDist[nr][nc] = newCost;
                        pq.offer(new Pair(nr, nc, newCost));
                    }
                }
            }
        }
        return -1;
    }
}
