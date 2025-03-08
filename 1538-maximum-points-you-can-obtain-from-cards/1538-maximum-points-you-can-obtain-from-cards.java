class Solution {
    public int maxScore(int[] c, int k) {
        int total=0;
        for(int i=0;i<k;i++){
            total+=c[i];
        }
        int ans=total;
        for(int i=k-1, j=c.length-1;i>=0;i--,j--){
            total+=c[j]-c[i];
            ans=Math.max(ans,total);
        }
        return ans;
    }
}