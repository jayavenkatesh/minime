class Solution {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb=new StringBuilder();
        for(String a:words){
            sb.append(a);
            if(sb.toString().equals(s)){
                return true;
            }
        }
        
        return false;
    }
}