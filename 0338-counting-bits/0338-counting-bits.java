class Solution {
    public int[] countBits(int n) {
        var ans = new int[n+1];
        zip(ans,1,1);
        return ans;
    }
    void zip(int[] ans,int i,int count){
        if(i >= ans.length) return;
        ans[i] = count;
        zip(ans,i << 1,count);
        zip(ans,(i<<1) + 1,count+1);
    }
}