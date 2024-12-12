class Solution {
    public long pickGifts(int[] gifts, int k) {
        long ans=0;
        PriorityQueue<Integer> heap=new PriorityQueue(Collections.reverseOrder());
        for(int i:gifts){
            heap.offer(i);
        }
        for(int i=0;i<k;i++){
            int n=heap.poll();
            int z=(int) (Math.sqrt(n));
            heap.offer(z);
        }
        while(!heap.isEmpty()){
            ans+=heap.poll();
        }
        return ans;
    }
}