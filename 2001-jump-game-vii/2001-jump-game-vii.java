class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        if(s == null || s.length() == 0) return false;
        int n = s.length();
        if(s.charAt(n - 1) == '1') return false;
        
        
        boolean[] dp = new boolean[n];
        dp[0] = true;
        
        int start = 0;
        int end = 0;
        for(int i = 0; i < n; i++){
            if(!dp[i]){
                continue;
            }
            
            start = Math.max(end + 1, i + minJump);
            end = Math.min(n - 1, i + maxJump);
 
            for(int j = start; j <= end; j++){
                if(s.charAt(j) == '0'){
                    dp[j] = true; 
                }                
            }
            if(dp[n - 1]) return true;
        }
        return dp[n-1];
    }
}