class Solution {
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp=new int[arr.length+1];
        for(int i=arr.length-1;i>=0;i--){
            int max=(int) -1e9;
            int len=0;
            int ans=(int) -1e9;
            for(int j=i;j<Math.min(arr.length,i+k);j++){
                len++;
                max=Math.max(max,arr[j]);
                int sum=len*max+dp[j+1];
                ans=Math.max(ans,sum);
            }
            dp[i] = ans;
        }
        return dp[0];
    }
}