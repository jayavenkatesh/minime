class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int[] arr=new int[n*n+1];
        for(int[] a:grid){
            for(int i:a) arr[i]++;
        }
        int a=0;
        int b=0;
        for(int i=1;i<n*n+1;i++){
            if(arr[i]==0){
                b=i;
            }
            if(arr[i]==2) a=i;
        }
        return new int[]{a,b};
    }
}