class Solution {
    public int countPrefixes(String[] words, String s) {
        int c=0;
        for(String prf:words){
            if(s.startsWith(prf)){
                c++;
            }
        }
        return c;
    }
}