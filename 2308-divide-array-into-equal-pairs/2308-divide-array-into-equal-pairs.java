class Solution {
    public boolean divideArray(int[] nums) {
        int[] inds=new int[501];
        for(int i:nums) inds[i]++;
        for(int i:inds) if(i%2!=0) return false;
        return true;
    }
}