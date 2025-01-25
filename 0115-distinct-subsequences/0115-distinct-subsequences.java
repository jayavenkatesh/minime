class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        dp=new int[n][m];
        for(int[] a:dp) Arrays.fill(a,-1);
        return rec(n-1,m-1,s,t);
    }
    int rec(int i,int j,String s1,String s2){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = rec(i-1,j-1,s1,s2)+rec(i-1,j,s1,s2);
        }
        return dp[i][j] = rec(i-1,j,s1,s2);
    }
}