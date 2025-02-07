class Solution {
    public boolean canFinish(int N, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList());
        }
        for(int[] a:prerequisites){
            adj.get(a[0]).add(a[1]);
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
        if(topo.size()==N) return true;
        return false;
    }
}