class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] arr=new int[n][n];
        for(int[] a:arr) Arrays.fill(a,(int) 1e9);
        for(int[] a:edges){
            int a1=a[0];
            int a2=a[1];
            int w=a[2];
            arr[a1][a2]=w;
            arr[a2][a1]=w;
        }
        for(int i=0;i<n;i++) arr[i][i]=0;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(arr[i][k]==1e9 || arr[k][j]==1e9) continue;
                    arr[i][j]=Math.min(arr[i][j],arr[i][k]+arr[k][j]);
                }
            }
        }
        int city=-1;
        int min=n+1;
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=0;j<n;j++){
                if(arr[i][j]<=distanceThreshold) c++;
            }
            if(min>=c){
                city=i;
                min=c;
            }
        }
        return city;
    }
}