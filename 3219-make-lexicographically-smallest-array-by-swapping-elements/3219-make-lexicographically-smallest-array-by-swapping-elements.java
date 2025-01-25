class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        List<PriorityQueue<Integer>> list=new ArrayList();
        int[] arr=new int[nums.length];
        int j=0;
        for(int i:nums) arr[j++]=i;
        Arrays.sort(arr);
        HashMap<Integer,Integer> hm=new HashMap();
        list.add(new PriorityQueue());
        list.get(0).offer(arr[0]);
        j=0;
        hm.put(arr[0],0);
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]<=limit){
                list.get(j).offer(arr[i]);
                
            }
            else{
                list.add(new PriorityQueue());
                j++;
                list.get(j).offer(arr[i]);
            }
            hm.put(arr[i],j);
        }
        int[] ans=new int[nums.length];
        int z=0;
        for(int i=0;i<nums.length;i++){
            int a=nums[i];
            int y=hm.get(a);
            ans[z++]=list.get(y).poll();
        }
        return ans;
    }
}

