class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        dp=new int[grid.length][grid[0].length];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        dp[0][0]=grid[0][0];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(i==0 && j==0){
                    continue;
                }
                int left=Integer.MAX_VALUE;
                int up=Integer.MAX_VALUE;
                if(j>0){
                    left=grid[i][j]+dp[i][j-1];
                }
                if(i>0){
                    up=grid[i][j]+dp[i-1][j];
                } 
                dp[i][j]=Math.min(left,up);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}