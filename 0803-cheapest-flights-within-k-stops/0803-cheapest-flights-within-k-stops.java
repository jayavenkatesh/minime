class pair{
    int node;
    int price;
    int level;
    pair(int n,int p,int l){
        this.node=n;
        this.price=p;
        this.level=l;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj=new ArrayList();
        for(int i=0;i<n;i++) adj.add(new ArrayList());
        for(int[] a:flights){
            adj.get(a[0]).add(new int[]{a[1],a[2]});
        }
        Queue<pair> queue=new LinkedList();
        int[] dist=new int[n];
        Arrays.fill(dist,(int) 1e9);
        dist[src]=0;
        queue.offer(new pair(src,0,0));
        while(!queue.isEmpty()){
            pair p=queue.poll();
            int lev=p.level;
            int d=p.price;
            int node=p.node;
            if(lev==k+1){
                if(dist[dst]==1e9) return -1;
                return dist[dst];
            }
            for(int[] a:adj.get(node)){
                int val=a[1]+d;
                if(val<dist[a[0]]){
                    dist[a[0]]=val;
                    queue.offer(new pair(a[0],val,lev+1));
                }
            }
        }
        if(dist[dst]==1e9) return -1;
        return dist[dst];
    }
}