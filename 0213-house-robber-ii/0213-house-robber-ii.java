class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int a=fun(Arrays.copyOfRange(nums,1,nums.length));
        int b=fun(Arrays.copyOfRange(nums,0,nums.length-1));
        return Math.max(a,b);
        
    }
    int fun(int[] nums){
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int prev=nums[0];
        int prev2=0;
        for(int i=1;i<nums.length;i++){
            int pick=nums[i];
            if(i>1){
                pick+=prev2;
            }
            int notPick=prev;
            int cur=Math.max(pick,notPick);
            prev2=prev;
            prev=cur;
        }
        return prev;
    }
}