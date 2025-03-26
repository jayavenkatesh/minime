class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] arr=new int[grid.length*grid[0].length];
        int j=0;
        for(int[] a:grid) for(int i:a) arr[j++]=i;
        Arrays.sort(arr);
        int m=arr[(j-1)/2];
        int ans=0;
        for(int i:arr){
            if(i==m) continue;
            if(Math.abs(i-m)%x!=0) return -1;
            ans+=Math.abs((i-m)/x);
        }
        return ans;
    }
}