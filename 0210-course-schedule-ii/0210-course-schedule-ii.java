class Solution {
    List<Integer> ans;
    public int[] findOrder(int N, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList());
        }
        for(int[] a:prerequisites){
            adj.get(a[1]).add(a[0]);
        }
        
        
        int[] indnum=new int[N];
        for(int i=0;i<N;i++){
            for(int j:adj.get(i)){
                indnum[j]++;
            }
        }
        Queue<Integer> queue=new LinkedList();
        for(int i=0;i<N;i++){
            if(indnum[i]==0) queue.offer(i);
        }
        List<Integer> topo=new ArrayList();
        while(!queue.isEmpty()){
            int a=queue.poll();
            topo.add(a);
            for(int z:adj.get(a)){
                indnum[z]--;
                if(indnum[z]==0) queue.offer(z);
            }
        }
        if(topo.size()!=N) return new int[]{};
        int[] arr=new int[N];
        int s=0;
        for(int i:topo){
            arr[s++]=i;
        }
        return arr;
    }
}