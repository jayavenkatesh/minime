class pair {
    int val;
    int index;

    pair() {

    }

    pair(int a,int d) {
        this.val = a;
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
            heap.offer(new pair(nums[i],i));
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
