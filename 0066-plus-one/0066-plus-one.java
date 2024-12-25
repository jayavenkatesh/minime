class Solution {
    public int[] plusOne(int[] digits) {
        int flag=0;
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]!=9){
                digits[i]+=1;
                flag=1;
                break;
            }
            else{
                digits[i]=0;
            }
        }
        int[] ans=new int[digits.length+1];
        if(flag==0){
            ans[0]=1;
            return ans;
        }
        return digits;
    }
}