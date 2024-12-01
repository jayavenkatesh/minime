class Solution {
    public int findFinalValue(int[] nums, int original) {
        while(true){
                if(found(nums,original)){
                    original*=2;
                }
                else{
                    return original;
                }   
        }
    }
    boolean found(int[] nums,int original ){
        for(int i:nums){
            if(i==original){
                return true;
            }
        }
        return false;
    }
}