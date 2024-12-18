class Solution {
    public int[] arrayChange(int[] nums, int[][] op) {
        HashMap<Integer,Integer> hm=new HashMap();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],i);
        }
        for(int i=0;i<op.length;i++){
            int[] arr=op[i];
            int a=arr[0];
            int b=arr[1];
            hm.put(b,hm.get(a));
            hm.remove(a);
        }
        int[] ans=new int[nums.length];
        for (Map.Entry<Integer, Integer> set : hm.entrySet()){
            ans[set.getValue()]=set.getKey();
        }
        return ans;
    }
}