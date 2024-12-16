class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> heap=new PriorityQueue();
        for(int i:nums){
            heap.offer(i);
        }
        while(k-- >0){
            int val=heap.poll();
            for(int i=0;i<nums.length;i++){
                if(val==nums[i]){
                    nums[i]=nums[i]*multiplier;
                    heap.offer(nums[i]);
                    break;
                }
            }
        }
        return nums;
    }
}