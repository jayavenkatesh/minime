class Solution {
    public long countBadPairs(int[] a) {
    long cnt=0;
    int n= a.length;
    HashMap<Integer,Integer> mp= new HashMap<>();
    for(int i=0;i<n;i++){
        int prev= mp.getOrDefault(i-a[i],0);
        cnt+= prev;
        mp.put(i-a[i],prev+1);
    }
    return 1L*n*(n-1)/2-cnt;
}
}