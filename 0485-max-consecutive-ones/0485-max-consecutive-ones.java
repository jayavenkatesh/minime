class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int temp=0;
        for(int i:nums){
            if(i==1) temp++;
            if(i==0) {
                max=Math.max(max,temp);
                temp=0;
            }
            
        }
        return Math.max(max,temp);
    }
}