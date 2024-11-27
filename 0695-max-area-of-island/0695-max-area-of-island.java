class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    int val=dfs(i,j,grid,visited);
                    ans=Math.max(ans,val);
                }
            }
        }
        return ans;
    }
    int dfs(int i,int j,int[][] grid,boolean[][] visited){
        visited[i][j]=true;
        int[] r={-1,0,+1,0};
        int[] c={0,+1,0,-1};
        int m=1;
        for(int a=0;a<r.length;a++){
            int nr=i+r[a];
            int nc=j+c[a];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && !visited[nr][nc] && grid[nr][nc]==1){
                m+=dfs(nr,nc,grid,visited);
            }
        }
        return m;
    }
}