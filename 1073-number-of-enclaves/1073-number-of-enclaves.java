class Solution {
    boolean[][] vis;
    int n,m;
    int[] dr={1,0,-1,0};
    int[] dc={0,1,0,-1};
    public int numEnclaves(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        vis=new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            if(grid[i][0]==1 && !vis[i][0]) dfs(i,0,grid);
            if(grid[i][m-1]==1 && !vis[i][m-1]) dfs(i,m-1,grid);
        }
        for(int i=0;i<m;i++){
            if(grid[0][i]==1 && !vis[0][i]) dfs(0,i,grid);
            if(grid[n-1][i]==1 && !vis[n-1][i]) dfs(n-1,i,grid);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]) ans++;
            }
        }
        return ans;
    }
    void dfs(int i,int j,int[][] grid){
        vis[i][j]=true;
        for(int z=0;z<4;z++){
            int r=i+dr[z];
            int c=j+dc[z];
            if(r>=0 && r<n && c>=0 && c<m && !vis[r][c] && grid[r][c]==1){
                dfs(r,c,grid);
            }
        }
    }
}