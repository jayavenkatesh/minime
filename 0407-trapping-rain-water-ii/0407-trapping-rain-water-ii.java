class Pair {
    int row, col, height;

    Pair(int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
    }
}

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;

        if (n <= 2 || m <= 2) return 0;
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> a.height - b.height);
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            heap.offer(new Pair(i, 0, heightMap[i][0]));
            heap.offer(new Pair(i, m - 1, heightMap[i][m - 1]));
            visited[i][0] = true;
            visited[i][m - 1] = true;
        }
        for (int j = 1; j < m - 1; j++) {
            heap.offer(new Pair(0, j, heightMap[0][j]));
            heap.offer(new Pair(n - 1, j, heightMap[n - 1][j]));
            visited[0][j] = true;
            visited[n - 1][j] = true;
        }
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int stored = 0;
        while (!heap.isEmpty()) {
            Pair p = heap.poll();
            for (int i = 0; i < 4; i++) {
                int newRow = p.row + dr[i];
                int newCol = p.col + dc[i];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    int cur = Math.max(p.height, heightMap[newRow][newCol]);
                    stored += Math.max(0, p.height - heightMap[newRow][newCol]);
                    heap.offer(new Pair(newRow, newCol, cur));
                }
            }
        }
        return stored;
    }
}
