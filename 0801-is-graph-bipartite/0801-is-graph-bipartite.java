class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] col = new int[n];
        Arrays.fill(col, -1);
        for (int i = 0; i < n; i++) {
            if (col[i] != -1) continue;
            boolean bol=dfs(i,graph,n,col,0);
            if(!bol) return false;
        }
        return true;
    }
    boolean dfs(int i,int[][] graph,int n,int[] col,int c){
        col[i]=c;
        boolean b=true;
        for(int val:graph[i]){
            if(col[val]==-1){
                b=dfs(val,graph,n,col,1-c);
                if(!b) return b;
            }
            if(col[val]==col[i]) return false;
        }
        return true;
    } 
}