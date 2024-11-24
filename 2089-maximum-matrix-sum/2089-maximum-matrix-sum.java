class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;
        int negvals=0;
        int minval=Integer.MAX_VALUE;
        for(int[] row:matrix){
            for(int i:row){
                if(i<0){
                    negvals++;
                }
                int v=Math.abs(i);
                minval=Math.min(minval,v);
                sum+=v;
            }
        }
        if((negvals & 1) == 1){
            return sum-2*minval;
        }
        return sum;
        
    }
}