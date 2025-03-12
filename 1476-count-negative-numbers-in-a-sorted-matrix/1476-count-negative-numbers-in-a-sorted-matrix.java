class Solution {
    public int countNegatives(int[][] grid) {
        int cou=0;
        for(int[] arr:grid){
            for(int i:arr) if(i<0) cou++;
        }
        return cou;
    }
}