class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int l=1;
        int r= Arrays.stream(nums).max().getAsInt();
        int ans=r;
        while(l<r){
            int m=l+(r-l)/2;
            if(can(nums,m,maxOperations)){
                r=m;
                ans=r;
            }
            else{
                l=m+1;
            }
        }
        return ans;
    }
    boolean can(int[] nums,int max,int val){
        int op=0;
        for(int i:nums){
            op+=(i+max-1)/max-1;
            if(op>val){
                return false;
            }
        }
        return true;
    }
}