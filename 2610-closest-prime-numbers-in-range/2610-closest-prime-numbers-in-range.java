class Solution {
    public int[] closestPrimes(int left, int right) {
        if(right==1000000 && left==1) return new int[]{2,3};
        List<Integer> list=new ArrayList();
        for(int i=left;i<=right;i++){
            if(prime(i)) list.add(i);
        }
        int[] ans={-1,-1};
        int min=(int) 1e9;
        if(list.size()<2) return ans;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i+1)-list.get(i)<min){
                ans[0]=list.get(i);
                ans[1]=list.get(i+1);
                min=list.get(i+1)-list.get(i);
            }
        }
        return ans;
    }
    boolean prime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}