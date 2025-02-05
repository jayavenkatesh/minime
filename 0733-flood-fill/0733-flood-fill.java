class Solution {
    int[] dr={-1,0,1,0};
    int[] dc={0,1,0,-1};
    int a=0;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        a=image[sr][sc];
        image[sr][sc]=color;
        if(a==color) return image;
        dfs(sr,sc,image,color);
        return image;
    }
    void dfs(int i,int j,int[][] image,int col){
        image[i][j]=col;
        for(int z=0;z<4;z++){
            int r=dr[z]+i;
            int c=dc[z]+j;
            if(r>=0 && r<image.length && c>=0 && c<image[0].length && image[r][c]==a){
                dfs(r,c,image,col);
            }
        }
    }
}