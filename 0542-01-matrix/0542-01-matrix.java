class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] ans=new int[n][m];
        boolean[][] vis=new boolean[n][m];
        Queue<int[]> queue=new LinkedList();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    queue.offer(new int[]{i,j});
                    vis[i][j]=true;
                }
            }
        }
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        int cou=0;
        while(!queue.isEmpty()){
            cou++;
            int siz=queue.size();
            for(int i=0;i<siz;i++){
                int[] arr=queue.poll();
                for(int j=0;j<4;j++){
                    int r=dr[j]+arr[0];
                    int c=dc[j]+arr[1];

                    if(r>=0 && r<n && c>=0 && c<m && !vis[r][c]){
                        ans[r][c]=cou;
                        vis[r][c]=true;
                        queue.offer(new int[]{r,c});
                    }
                }
            }
        }
        return ans;
    }
}