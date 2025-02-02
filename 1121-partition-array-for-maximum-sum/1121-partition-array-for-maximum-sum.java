class Solution {
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp=new int[arr.length];
        Arrays.fill(dp,-1);
        return rec(0,arr,k);
    }
    int rec(int i,int[] arr,int k){
        if(i>=arr.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int max=(int) -1e9;
        int len=0;
        int ans=(int) -1e9;
        for(int j=i;j<Math.min(arr.length,i+k);j++){
            len++;
            max=Math.max(max,arr[j]);
            int sum=len*max+rec(j+1,arr,k);
            ans=Math.max(ans,sum);
        }
        return dp[i] = ans;
    }
}