class Solution {
    int[] arr = new int[45+1];

    public int climbStairs(int n) {
        Arrays.fill(arr, -1);
        arr[0] = 1;
        arr[1] = 1;
        for(int i=2;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}