class Solution {
    int[] arr =new int[31];
    public int fib(int n) {
        Arrays.fill(arr,-1);
        return hel(n);
    }
    int  hel(int n){
        if(arr[n]!=-1) return arr[n];
        if(n<2) {
			return arr[n]= n;
		}
		return arr[n]= hel(n-1)+hel(n-2);
    }
   
}