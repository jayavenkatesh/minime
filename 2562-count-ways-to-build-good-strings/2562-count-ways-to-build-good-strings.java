class Solution {
     private static final int MOD = 1_000_000_007;
    HashMap<Integer,Integer> hm=new HashMap();
    public int countGoodStrings(int low, int high, int zero, int one) {
        String s="";
        int ans=rec(low,high,zero,one,0);
        return ans;
    }
    int rec(int low, int high, int zero, int one,int len){
        if(len>high){
            return 0;
        }
        if(hm.containsKey(len)){
            return hm.get(len);
        }
        long res=0;
        if(len>=low){
            res=1;
        }
        res=(res+rec(low,high,zero,one,len+zero))%MOD;
        res=(res+rec(low,high,zero,one,len+one))%MOD;
        hm.put(len,(int)res);
        return (int) res;
    }
}