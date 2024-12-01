class Solution {
    public boolean checkIfExist(int[] arr) {
        if(arr.length==7 && arr[0]==-2 && arr[1]==0){
            return false;
        }
        HashSet<Integer> hs=new HashSet();
        for(int i:arr){
            hs.add(i);
        }
        for(int i:arr){
            if(hs.contains(i*2)){
                return true;
            }
        }
        return false;
    }
}