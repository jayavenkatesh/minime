class Solution {
    int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        dp=new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return rec(0,0,triangle);
    }
    int rec(int i,int j,List<List<Integer>> tri){
        if(i>=tri.size() || j>=tri.get(i).size()){
            return Integer.MAX_VALUE;
        }
        if(i==tri.size()-1){
            return tri.get(i).get(j);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down=tri.get(i).get(j)+rec(i+1,j,tri);
        int dRight=tri.get(i).get(j)+rec(i+1,j+1,tri);

        return dp[i][j]=Math.min(down,dRight);
    }
}