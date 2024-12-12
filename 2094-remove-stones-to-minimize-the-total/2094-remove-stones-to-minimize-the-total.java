class Solution {
    public int minStoneSum(int[] piles, int k) {
        int ans=0;
        PriorityQueue<Integer> heap=new PriorityQueue<>((a,b) -> b-a);
        for(int i:piles){
            heap.offer(i);
        }
        for(int i=0;i<k;i++){
            int n=heap.poll();
            int z=0;
            if(n%2!=0){
                z=(int) (Math.floor(n/2)+1);
            }
            else{
                z=n/2;
            }
            
            heap.offer(z);
        }
        while(!heap.isEmpty()){
            ans+=heap.poll();
        }
        return ans;
    }
}