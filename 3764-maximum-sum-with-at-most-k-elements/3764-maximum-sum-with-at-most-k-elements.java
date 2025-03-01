class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        PriorityQueue<Integer> heap=new PriorityQueue(Collections.reverseOrder());
        for(int i=0;i<grid.length;i++){
            int[] a=grid[i];
            Arrays.sort(a);
            int z=limits[i];
            for(int j=a.length-z;j<a.length;j++){
                heap.offer(a[j]);
            }
        } 
        long ans=0;  
        while(!heap.isEmpty() && k-- > 0){
            ans+= heap.poll();
        }
        return ans;
    }
}