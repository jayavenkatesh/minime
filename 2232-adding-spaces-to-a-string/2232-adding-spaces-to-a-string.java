class Solution {
    public String addSpaces(String s, int[] spaces) {
        int a=0;
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<s.length()){
            if(a<spaces.length && spaces[a]==i){
                sb.append(" ");
                a++;
            }
            else{
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}