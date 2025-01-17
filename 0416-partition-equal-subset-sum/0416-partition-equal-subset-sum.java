class Solution {
    public boolean canPartition(int[] arr) {
        int sum=0;
        int n=arr.length;
		for(int i:arr){
			sum+=i;
		}
		if(sum%2==1){
			return false;
		}
		int k=sum/2;
		boolean[] dp=new boolean[k+1];
        dp[0]=true;
        if(arr[0]==k){
            return true;
        }
        if(k>=arr[0]) dp[arr[0]]=true;
        for(int i=1;i<n;i++){
            boolean[] cur=new boolean[k+1];
            cur[0]=true;
            for(int t=1;t<=k;t++){
                boolean notTake=dp[t];
                boolean take=false;
                if(t>=arr[i]){
                    take=dp[t-arr[i]];
                }
                cur[t]= notTake || take;   
            }
            dp=cur;
        }
        return dp[k];
        
    }
}
