class Solution {
    int[] dp;
    public int minCut(String s) {
        dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return rec(0,s)-1;
    }
    int rec(int i,String s){
        if(i>=s.length()) return 0;
        if(dp[i]!=-1) return dp[i];
        int min=(int) 1e9;
        for(int j=i;j<s.length();j++){
            if(pali(i,j,s)){
                int cost=1+rec(j+1,s);
                min=Math.min(min,cost);
            }
        }
        return dp[i] = min;
    }
    boolean pali(int i,int j,String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}