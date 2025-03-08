class Solution {
    public int minimumRecolors(String blocks, int k) {
        int cou=0;
        for(int i=0;i<k;i++){
            if(blocks.charAt(i)=='W'){
                cou++;
            }
        }
        int l=0;
        int val=cou;
        for(int r=k;r<blocks.length();r++){
            if(blocks.charAt(l)=='W') val--;
            if(blocks.charAt(r)=='W') val++;
            l++;
            cou=Math.min(cou,val);
        }
        return cou;
    }
}