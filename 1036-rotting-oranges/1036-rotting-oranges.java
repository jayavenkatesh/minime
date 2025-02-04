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
        int org=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.offer(new pair(i,j));
                }
                else if(grid[i][j]==1) org++;
            }
        }
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        int ans=0;
        while(!queue.isEmpty()){
            int n=queue.size();
            int b=0;
            for(int i=0;i<n;i++){
                pair p=queue.poll();
                for(int j=0;j<4;j++){
                    int r=dr[j]+p.row;
                    int c=dc[j]+p.col;
                    if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]==1){
                        queue.offer(new pair(r,c));
                        b=1;
                        grid[r][c]=2;
                        org--;
                    }
                }
            }
            if(b==1) ans++;
        }
        return org==0?ans:-1;
    }
}