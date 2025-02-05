class Solution {
    boolean[][] vis;
    int[] dr={-1,0,1,0};
    int[] dc={0,1,0,-1};
    int n;
    int m;
    public void solve(char[][] board) {
        n=board.length;
        m=board[0].length;
        vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && !vis[i][0]){
                dfs(i,0,board);
            }
            if(board[i][m-1]=='O' && !vis[i][m-1]){
                dfs(i,m-1,board);
            }
        }
        for(int i=0;i<m;i++){
            if(board[0][i]=='O' && !vis[0][i]){
                dfs(0,i,board);
            }
            if(board[n-1][i]=='O' && !vis[n-1][i]){
                dfs(n-1,i,board);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && !vis[i][j]) board[i][j]='X';
            }
        }
    }
    void dfs(int i,int j,char[][] board){
        vis[i][j]=true;

        for(int ind=0;ind<4;ind++){
            int r=i+dr[ind];
            int c=j+dc[ind];

            if(r>=0 && r<n && c>=0 && c<m && !vis[r][c] && board[r][c]=='O'){
                dfs(r,c,board);
            }
        }
    }
}