class Solution {
    public int[] countBits(int n) {
        int[] arr=new int[n+1];
        for(int i=0;i<=n;i++){
            int val=0;
            String s=Integer.toBinaryString(i);
            System.out.println(s);
            for(char c:s.toCharArray()){
                if(c=='1'){
                    val++;
                }
            }
            arr[i]=val;
        }

        return arr;
    }
}