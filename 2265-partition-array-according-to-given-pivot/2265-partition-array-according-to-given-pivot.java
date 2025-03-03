class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> list=new ArrayList();
        int n=nums.length;
        for(int i:nums){
            if(i<pivot) list.add(i);
        }
        for(int i:nums) if(i==pivot) list.add(i);
        for(int i:nums) if(i>pivot) list.add(i);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}