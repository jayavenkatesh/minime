class Solution {
    public int minCostClimbingStairs(int[] cost) {
         int ans[] = new int[cost.length];
         ans[0] = cost[0];
          ans[1] =  cost[1];
        for(int i=2; i<cost.length; i++){
             ans[i] = Math.min(ans[i-2] , ans[i-1]) + cost[i];
            
        }
         return  Math.min(ans[ans.length-1],ans[ans.length-2]);
    }
}