class Solution {
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        int m=grid[0].length;
        int n=grid.length;
        dp=new int[n][m][m];
        for(int[][] arr:dp){
            for(int[] a:arr){
                Arrays.fill(a,-1);
            }
        }
        return rec(0,0,m-1,grid,m);
    }
    int rec(int i,int j1,int j2,int[][] grid,int m){
        if(j1<0 || j1>=m || j2<0 || j2>=m){
            return (int) -1e7;
        }
        if(i==grid.length-1){
            return j1==j2?grid[i][j1]:grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2]!=-1){
            return dp[i][j1][j2];
        }
        int ans=(int) -1e7;
        for(int a=-1;a<2;a++){
            for(int b=-1;b<2;b++){
                int z=j1==j2?grid[i][j1]:grid[i][j1]+grid[i][j2];
                ans=Math.max(ans,z+rec(i+1,j1+a,j2+b,grid,m));
            }
        }
        return dp[i][j1][j2]=ans;
    }
}