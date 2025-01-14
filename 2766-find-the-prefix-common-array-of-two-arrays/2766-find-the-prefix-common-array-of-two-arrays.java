class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] ans=new int[A.length];
        HashMap<Integer,Integer> hm=new HashMap();
        for(int i=0;i<A.length;i++){
            int a=A[i];
            int b=B[i];
            hm.put(a,hm.getOrDefault(a,0)+1);
            hm.put(b,hm.getOrDefault(b,0)+1);
            int count=0;
            for(int m:hm.values()){
                if(m%2==0){
                    count+=m/2;
                }
            }
            ans[i]=count;
        }
        return ans;
    }
}