class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.offer((long) num);
        }
        int cou = 0;
        while (heap.size() > 1) {
            long a = heap.poll();
            if(a>=k) return cou;
            long b = heap.poll();
            long newElement = a * 2 + b;
            heap.offer(newElement);
            cou++;
        }
        return (heap.peek() >= k) ? cou : cou + 1;
    }
}
