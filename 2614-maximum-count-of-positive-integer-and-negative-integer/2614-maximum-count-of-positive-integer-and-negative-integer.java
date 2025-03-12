class Solution {
    public int maximumCount(int[] nums) {
        int a=0,b=0;
        for(int i:nums) {
            if(i==0) continue;
            if(i>0) a++;
            else b++;
        }
        return Math.max(a,b);
    }
}