class Solution {
    int[][] dp;
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        dp=new int[n][m];
        for(int[] a:dp) Arrays.fill(a,-1);
        return rec(n-1,m-1,s,p);
    }
    boolean rec(int i,int j,String s1,String s2){
        if(i<0 && j<0) return true;
        if(i>=0 && j<0) return false;
        
        if(i<0 && j>=0){
            for(int a=0;a<=j;a++){
                if(s2.charAt(a)!='*') return false;
            }
            return true;
        }
        if(dp[i][j]!=-1) return dp[i][j]==0?false:true;
        if((s1.charAt(i)==s2.charAt(j)) || s2.charAt(j)=='?') {
            boolean z=rec(i-1,j-1,s1,s2);
            if(z) dp[i][j]=1;
            else dp[i][j]=0;
            return z;
        } 
        if(s2.charAt(j)=='*'){
            boolean z= (rec(i,j-1,s1,s2) || rec(i-1,j,s1,s2));
            if(z) dp[i][j]=1;
            else dp[i][j]=0;
            return z;
        } 

        dp[i][j]=0;
        return false;

    }
}