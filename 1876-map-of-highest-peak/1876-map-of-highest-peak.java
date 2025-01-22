class Solution {
    class Pair {
        int r, c, h;

        Pair(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;

        int[][] ans = new int[n][m];
        for (int[] row : ans) {
            Arrays.fill(row, -1);
        }
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    ans[i][j] = 0;
                    queue.offer(new Pair(i, j, 0));
                }
            }
        }
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int row = p.r, col = p.c, height = p.h;
            for (int i = 0; i < 4; i++) {
                int r = row + dr[i];
                int c = col + dc[i];
                if (r >= 0 && r < n && c >= 0 && c < m && ans[r][c] == -1) {
                    ans[r][c] = height + 1; 
                    queue.offer(new Pair(r, c, ans[r][c])); 
                }
            }
        }
        return ans;
    }
}
