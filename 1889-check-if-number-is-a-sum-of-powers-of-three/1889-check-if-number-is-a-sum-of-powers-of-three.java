class Solution {
    public boolean checkPowersOfThree(int n) {
        return rec(n,0,0);
    }
    boolean rec(int n,int k,int i){
        if(n==k){
            return true;
        }
        if(i==17){
            return false;
        }
        boolean t=false;
        int z=(int) Math.pow(3,i);
        if(n>=z){
            t=rec(n,k+z,i+1);
        }
        boolean nt=rec(n,k,i+1);
        return t||nt;
    }
}