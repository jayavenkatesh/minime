class pair {
    int val;
    int left;
    int right;
    int index;

    pair() {

    }

    pair(int a, int b, int c, int d) {
        this.val = a;
        this.left = b;
        this.right = c;
        this.index = d;
    }
}

class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<pair> heap = new PriorityQueue<>((a, b) -> {
            if (a.val != b.val) {
                return a.val - b.val;
            } else {
                return a.index - b.index;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            int left = i == 0 ? -1 : nums[i - 1];
            int right = i == nums.length - 1 ? -1 : nums[i + 1];
            heap.offer(new pair(nums[i], left, right, i));
        }
        boolean[] visited = new boolean[nums.length];
        long ans = 0;
        while (!heap.isEmpty()) {
            pair p = heap.poll();
            if (visited[p.index]) continue;

            ans += p.val;
            visited[p.index] = true;
            if (p.index > 0) visited[p.index - 1] = true;
            if (p.index < nums.length - 1) visited[p.index + 1] = true;
        }
        return ans;
    }
}
