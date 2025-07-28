class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int max=0;
        for(int i:nums){
            max= max | i;
        }
        int[] count=new int[1];
        rec(new ArrayList(),nums,count,max);
        return count[0];
    }
    void rec(List<Integer> list,int[] arr,int[] c,int m){
        if(arr.length==0){
            int cur=0;
            for(Integer i:list){
                cur=cur|i;
            }
            if(m==cur){
                c[0]++;
            }
            return;
        }
        int a=arr[0];
        rec(list,Arrays.copyOfRange(arr,1,arr.length),c,m);
        list.add(a);
        rec(list,Arrays.copyOfRange(arr,1,arr.length),c,m);
        list.remove(list.size()-1);
    }
}