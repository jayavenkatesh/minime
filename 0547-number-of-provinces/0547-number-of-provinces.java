class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> list=new ArrayList();
        int n=isConnected.length;
        int m=isConnected[0].length;
        for(int i=0;i<n;i++){
            list.add(new ArrayList());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isConnected[i][j]==1){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        boolean[] vis=new boolean[n];
        int ans=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                ans++;
                bfs(i,list,vis);
            }
        }
        return ans;
    }
    void bfs(int z,List<List<Integer>> list,boolean[] vis){
        Queue<Integer> queue=new LinkedList();
        for(int i:list.get(z)){
            if(!vis[i]){
                queue.add(i);
                vis[i]=true;
            }
        }
        while(!queue.isEmpty()){
            int n=queue.size();
            for(int j=0;j<n;j++){
                int a=queue.poll();
                for(int i:list.get(a)){
                    if(!vis[i]){
                        vis[i]=true;
                        queue.add(i);
                    }
                }
            }
        }
    }
}