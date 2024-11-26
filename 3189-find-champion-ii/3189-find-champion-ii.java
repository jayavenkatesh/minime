class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] arr=new int[n];
        for(int[] a:edges){
            arr[a[1]]+=1;
        }
        int count=0;
        int in=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                count++;
                in=i;
            }
        }
        if(count==1){
            return in;
        }
        return -1;
    }
}