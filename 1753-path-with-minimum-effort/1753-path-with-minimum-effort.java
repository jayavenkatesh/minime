class pair{
    int row;
    int col;
    int e;
    pair(int i,int j,int e){
        this.row=i;
        this.col=j;
        this.e=e;
    } 
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<pair> queue=new PriorityQueue<>((a,b) -> a.e-b.e);
        int n=heights.length;
        int m=heights[0].length;
        int[][] eff=new int[n][m];
        for(int[] a:eff) Arrays.fill(a,(int) 1e9);
        eff[0][0]=0;
        queue.offer(new pair(0,0,0));
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        while(!queue.isEmpty()){
            pair p=queue.poll();
            int r=p.row;
            int c=p.col;
            int e=p.e;
            if(r==n-1 && c==m-1) return e;
            for(int i=0;i<4;i++){
                int row=r+dr[i];
                int col=c+dc[i];
                if(row>=0 && row<n && col>=0 && col<m){
                    int diff=Math.max(e,Math.abs(heights[row][col]-heights[r][c]));
                    if(diff<eff[row][col]){
                        eff[row][col]=diff;
                        queue.offer(new pair(row,col,diff));
                    }
                }
            }
        }
        return -1;
    }
}