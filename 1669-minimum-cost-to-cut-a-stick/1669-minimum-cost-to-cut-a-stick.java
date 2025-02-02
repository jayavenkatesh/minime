class Solution {
    int[][] dp;
    public int minCost(int N, int[] cuts) {
        int n=cuts.length+2;
        int[] arr=new int[n];
        arr[0]=0;
        arr[n-1]=N;
        int j=1;
        for(int i=0;i<cuts.length;i++) arr[j++]=cuts[i];
        Arrays.sort(arr);
        dp=new int[n][n];
        for(int[] a:dp) Arrays.fill(a,-1);
        return rec(1,n-2,arr);
    }
    int rec(int i,int j,int[] arr){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min=(int) 1e9;
        for(int k=i;k<=j;k++){
            int cuts=arr[j+1]-arr[i-1]+rec(i,k-1,arr)+rec(k+1,j,arr);
            min=Math.min(min,cuts);
        }
        return dp[i][j] = min;
    }
}