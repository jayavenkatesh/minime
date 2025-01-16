class Solution {
    int[] dp;
    public int minimumTotal(List<List<Integer>> tri) {
        int n=tri.size();
        int m=tri.get(n-1).size();
        dp=new int[m];
        for(int j=0;j<m;j++){
            dp[j]=tri.get(n-1).get(j);
        }
        for(int i=n-2;i>=0;i--){
            int[] cur=new int[m];
            for(int j=i;j>=0;j--){
                int down=tri.get(i).get(j)+dp[j];
                int dRight=tri.get(i).get(j)+dp[j+1];
                cur[j]=Math.min(down,dRight);
            }
            dp=cur;
        }
        return dp[0];
    }
}