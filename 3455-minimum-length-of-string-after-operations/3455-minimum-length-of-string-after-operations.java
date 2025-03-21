class Solution {
    public int minimumLength(String s) {
        int[] right=new int[26];
        for(char c:s.toCharArray()){
            right[c-'a']++;
        }
        int ans=0;
        for(int i:right){
            if(i==0){
                continue;
            }
            if(i%2==1){
                ans++;
            }
            else{
                ans+=2;
            }
        }
        return ans;
    }
}