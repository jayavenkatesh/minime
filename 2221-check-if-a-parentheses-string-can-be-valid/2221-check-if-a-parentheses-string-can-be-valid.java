class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2!=0){
            return false;
        }
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            if(locked.charAt(i)=='0'){
                sb.setCharAt(i,'*');
            }
        }
        s=sb.toString();
        int l=0;
        int lmax=0;
        for (char c:s.toCharArray()){
            if(c=='('){
                l++;
                lmax++;
            }
            else if(c==')'){
                l--;
                lmax--;
            }
            else{
                l--;
                lmax++;
            }
            if(lmax<0){
                return false;
            }
            if(l<0){
                l=0;
            }
        }
        return l==0;
    }
}