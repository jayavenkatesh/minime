// class Solution {
//     public String removeOccurrences(String s, String part) {
//         StringBuilder sb=new StringBuilder(s);
//         int i=0;
//         int j=0;
//         while(i<sb.length()){
//             char c1=sb.charAt(i);
//             char c2=sb.charAt(j);
//             if(c1==c2){
//                 j++;
//             }
//             else{
//                 j=0;
//                 if(c1==c2) j++;
//             }
//             if(j==part.length()){
//                 sb.delete(j-part.length(),j-1);
//                 i=i-part.length()-1;
//             }
//             i++;
//         }
//         return sb.toString();
//     }
// }
class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        while (true) {
            int i = sb.indexOf(part);
            if (i == -1) {
                break;
            }
            sb.delete(i, i + part.length());
        }
        return sb.toString();
    }
}
