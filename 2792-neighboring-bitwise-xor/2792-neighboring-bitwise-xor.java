class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int f=0;
        int l=0;
        for(int i:derived){
            if(i==1){
                l=l==0?1:0;
            }
        }
        return f==l;
    }
}