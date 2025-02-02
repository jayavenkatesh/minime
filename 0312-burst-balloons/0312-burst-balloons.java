class Solution {
    int[][] dp;
    public int maxCoins(int[] cuts) {
        int N=cuts.length;
        int n=cuts.length+2;
        int[] arr=new int[n];
        arr[0]=1;
        arr[n-1]=1;
        int j=1;
        for(int i=0;i<cuts.length;i++) arr[j++]=cuts[i];
        dp=new int[n][n];
        for(int[] a:dp) Arrays.fill(a,-1);
        return rec(1,n-2,arr);
    }
    int rec(int i,int j,int[] arr){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min=(int) -1e9;
        for(int k=i;k<=j;k++){
            int cuts=arr[j+1]*arr[i-1]*arr[k]+rec(i,k-1,arr)+rec(k+1,j,arr);
            min=Math.max(min,cuts);
        }
        return dp[i][j] = min;
    }
}