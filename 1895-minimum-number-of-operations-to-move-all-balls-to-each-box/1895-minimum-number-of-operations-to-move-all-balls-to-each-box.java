class Solution {
    public int[] minOperations(String boxes) {
        int[] ans=new int[boxes.length()];
        List<Integer> list=new ArrayList();
        for(int i=0;i<boxes.length();i++){
            char c=boxes.charAt(i);
            if(c=='1'){
                list.add(i);
            }
        }
        for(int i=0;i<boxes.length();i++){
            int a=0;
            for(int j:list){
                int z=Math.abs(i-j);
                a+=z;
            }
            ans[i]=a;
        }
        return ans;
    }
}