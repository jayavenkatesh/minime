class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] ans=new int[queries.length];
        List<List<Integer>> adj=new ArrayList();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList());
        }
        for(int i=0;i<n-1;i++){
            adj.get(i).add(i+1);
        }
        int[] shotDist=bfs(n,adj);
        for(int i=0;i<queries.length;i++){
            int[] arr=queries[i];
            adj.get(arr[0]).add(arr[1]);

            shotDist=bfs(n,adj);
            ans[i]=shotDist[n-1];
        }
        return ans;
    }
    int[] bfs(int n,List<List<Integer>> adj){
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        Queue<Integer> queue=new LinkedList();
        queue.offer(0);
        while(!queue.isEmpty()){
            int cur=queue.poll();

            for(int a:adj.get(cur)){
                if(dist[cur]+1<dist[a]){
                    dist[a]=dist[cur]+1;
                    queue.add(a);
                }
            }
        }
        return dist;
    }
}