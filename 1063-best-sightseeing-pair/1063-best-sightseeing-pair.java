class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans=0;
        int curSum=values[0]-1;
        for(int i=1;i<values.length;i++){
            ans=Math.max(ans,values[i]+curSum);
            curSum=Math.max(curSum-1,values[i]-1);
        }
        return ans;
    }
}