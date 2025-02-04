class pair{
    int row;
    int col;
    pair(int r,int c){
        this.row=r;
        this.col=c;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<pair> queue=new LinkedList();
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.offer(new pair(i,j));
                    visited[i][j]=true;
                }
            }
        }
        int ans=0;
        while(!queue.isEmpty()){
            //ans++;
            int n=queue.size();
            int[] dr={-1,0,1,0};
            int[] dc={0,1,0,-1};
            int b=0;
            for(int i=0;i<n;i++){
                pair p=queue.poll();
                for(int j=0;j<4;j++){
                    int r=dr[j]+p.row;
                    int c=dc[j]+p.col;
                    if(r>=0 && r<grid.length && c>=0 && c<grid[0].length &&grid[r][c]==1 && !visited[r][c]){
                        queue.offer(new pair(r,c));
                        b=1;
                        grid[r][c]=2;
                        visited[r][c]=true;
                    }
                }
            }
            if(b==1) ans++;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return ans;
    }
}