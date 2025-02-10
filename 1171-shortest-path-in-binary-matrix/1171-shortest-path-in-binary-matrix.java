class pair{
    int row;
    int col;
    int dist;
    pair(int i,int j,int e){
        this.row=i;
        this.col=j;
        this.dist=e;
    } 
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] heights) {
        Queue<pair> queue=new LinkedList<>();
        int n=heights.length;
        int m=heights[0].length;
        int[][] eff=new int[n][m];
        for(int[] a:eff) Arrays.fill(a,(int) 1e9);
        eff[0][0]=1;
        if(heights[0][0]==1) return -1;
        queue.offer(new pair(0,0,1));
        int[] dr={-1,-1,-1,0,1,1,1,0};
        int[] dc={-1,0,1,1,1,0,-1,-1};
        while(!queue.isEmpty()){
            pair p=queue.poll();
            int r=p.row;
            int c=p.col;
            int e=p.dist;
            if(r==n-1 && c==m-1) return e;
            for(int i=0;i<8;i++){
                int row=r+dr[i];
                int col=c+dc[i];
                if(row>=0 && row<n && col>=0 && col<m && heights[row][col]==0){
                    int dist=1+e;
                    if(dist<eff[row][col]){
                        eff[row][col]=dist;
                        queue.offer(new pair(row,col,dist));
                    }
                }
            }
        }
        return -1;
    }
}