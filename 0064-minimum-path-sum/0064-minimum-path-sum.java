class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        dp=new int[grid.length][grid[0].length];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return rec(grid.length-1,grid[0].length-1,grid);
    }
    int rec(int i,int j,int[][] grid){
        if(i<0 || j<0){
            return 1000000;
        }
        if(i==0 && j==0){
            return grid[0][0];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up=grid[i][j]+rec(i-1,j,grid);
        int left=grid[i][j]+rec(i,j-1,grid);
        return dp[i][j] = Math.min(up,left);
    }
}