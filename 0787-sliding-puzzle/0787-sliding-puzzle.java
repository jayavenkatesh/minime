class Solution {
    public int slidingPuzzle(int[][] board) {
        HashSet<String> hs = new HashSet();
        String s = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                s += board[i][j];
            }
        }
        if (s.equals("123450")) {
            return 0;
        }
        hs.add(s);
        Queue<String> queue = new LinkedList();
        queue.offer(s);
        int[][] adj = { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
        int count = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            while (n > 0) {
                String temp = queue.poll();
                if (temp.equals("123450")) {
                    return count;
                }
                int in = temp.indexOf('0');
                for (int swap : adj[in]) {
                    StringBuilder sb = new StringBuilder(temp);
                    sb.setCharAt(in, temp.charAt(swap));
                    sb.setCharAt(swap, '0');
                    String z = sb.toString();

                    if (hs.contains(z)) {
                        continue;
                    }
                    hs.add(z);
                    queue.offer(z);
                }
                n--;
            }
            count++;
        }
        return -1;
    }
}