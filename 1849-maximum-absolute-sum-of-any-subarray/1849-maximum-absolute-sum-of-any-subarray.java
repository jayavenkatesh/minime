class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max=0;
        int min=0;
        int curmax=0;
        int curmin=0;

        for(int n:nums){
            curmax=Math.max(n,curmax+n);
            max=Math.max(curmax,max);

            curmin=Math.min(n,curmin+n);
            min=Math.min(curmin,min);
        }
        return Math.max(Math.abs(max),Math.abs(min));
    }
}