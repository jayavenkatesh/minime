class Solution {
    public int[] minOperations(String boxes) {
        int[] ans=new int[boxes.length()];
        int balls=0;
        int moves=0;
        for(int i=0;i<boxes.length();i++){
            ans[i]=balls+moves;
            if(boxes.charAt(i)=='1'){
                balls++;
            }
            moves=ans[i];
        }
        balls=0;
        moves=0;
        for(int i=boxes.length()-1;i>=0;i--){
            ans[i]+=balls+moves;
            moves=balls+moves;
            if(boxes.charAt(i)=='1'){
                balls++;
            }
        }
        return ans;
    }
}