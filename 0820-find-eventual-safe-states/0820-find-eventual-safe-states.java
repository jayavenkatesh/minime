class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj=new ArrayList();
        int n=graph.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList());
        }
        for(int i=0;i<n;i++){
            int[] arr=graph[i];
            for(int j:arr){
                adj.get(j).add(i);
            }
        }
        int[] inedges=new int[n];
        for(int i=0;i<adj.size();i++){
            List<Integer> l=adj.get(i);
            for(int j:l){
                inedges[j]++;
            }
        }
        Queue<Integer> queue=new LinkedList();
        for(int i=0;i<n;i++){
            if(inedges[i]==0) queue.offer(i);
        }
        List<Integer> ans=new ArrayList();
        while(!queue.isEmpty()){
            int a=queue.poll();
            if(inedges[a]==0) ans.add(a);
            for(int z:adj.get(a)){
                inedges[z]--;
                if(inedges[z]==0) queue.offer(z);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}