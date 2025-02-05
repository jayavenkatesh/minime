class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int a=image[sr][sc];
        image[sr][sc]=color;
        boolean[][] visited =new boolean[image.length][image[0].length];
        dfs(sr,sc,image,color,visited,a);
        return image;
    }
    void dfs(int i,int j,int[][] image,int col,boolean[][] vis,int a){
        vis[i][j]=true;
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        for(int z=0;z<4;z++){
            int r=dr[z]+i;
            int c=dc[z]+j;
            if(r>=0 && r<image.length && c>=0 && c<image[0].length && !vis[r][c] && image[r][c]==a){
                image[r][c]=col;
                dfs(r,c,image,col,vis,a);
            }
        }
    }
}