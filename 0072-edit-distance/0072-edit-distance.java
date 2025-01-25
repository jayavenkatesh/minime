class Solution {
    int[][] dp;
    public int minDistance(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++) dp[i][0]=i;
        for(int i=0;i<=m;i++) dp[0][i]=i;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(1+dp[i-1][j],Math.min(1+dp[i][j-1],1+dp[i-1][j-1]));
            }
        }
        return dp[n][m];
    }
    int rec(int i,int j,String s1,String s2){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j] = rec(i-1,j-1,s1,s2);
        return dp[i][j] = Math.min(1+rec(i-1,j,s1,s2),Math.min(1+rec(i,j-1,s1,s2),1+rec(i-1,j-1,s1,s2)));
    }
}