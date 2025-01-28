class pair{
    int r;
    int c;
    pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}
class Solution {
    public int findMaxFish(int[][] grid) {
        Queue<pair> queue=new LinkedList();
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int ans=0;
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]!=0){
                    visited[i][j]=true;
                    queue.offer(new pair(i,j));
                    int temp=grid[i][j];
                    while(!queue.isEmpty()){
                        pair arr=queue.poll();
                        for(int q=0;q<4;q++){
                            int row=arr.r+dr[q];
                            int col=arr.c+dc[q];

                            if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && !visited[row][col]){
                                visited[row][col]=true;
                                if(grid[row][col]!=0){
                                    temp+=grid[row][col];
                                    queue.offer(new pair(row,col));
                                }

                            }
                        }
                    }
                    ans=temp>ans?temp:ans;
                    
                }
            }
        }
        return ans;
    }
}