class Solution {
    public boolean isThree(int n) {
        if(prime(n)==1) return true;
        return false;
    }
    int prime(int n){
        int cou=0;
        for(int i=2;i*2<=n;i++){
            if(n%i==0){
                cou++;
            }
        }
        return cou;
    }
}