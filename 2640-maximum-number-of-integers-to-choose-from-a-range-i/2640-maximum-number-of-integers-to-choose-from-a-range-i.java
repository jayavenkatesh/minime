class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int count=0;
        int sum=0;
        HashSet<Integer> hs=new HashSet();
        for(int i:banned){
            hs.add(i);
        }
        for(int i=1;i<=n;i++){
            if(!hs.contains(i)){
                sum+=i;
                count++;
            }
            if(sum>maxSum){
                count--;
                break;
            }
        }
        return count==0?count:count;
    }
}