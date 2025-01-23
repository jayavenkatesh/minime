class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        dp=new int[n][m];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return rec(n-1,m-1,text1,text2);
    }
    int rec(int i,int j,String s1,String s2){
        if(i<0 || j<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return 1+rec(i-1,j-1,s1,s2);
        }
        return dp[i][j] = Math.max(rec(i-1,j,s1,s2),rec(i,j-1,s1,s2));
    }
}