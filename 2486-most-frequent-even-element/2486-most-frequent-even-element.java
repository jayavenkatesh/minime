class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap();
        for(int i:nums){
            if(i%2==0) hm.put(i,hm.getOrDefault(i,0)+1);
        }
        int maxi=-1;
        int freq=-1;
        for(Map.Entry<Integer,Integer> m:hm.entrySet()){
            if(m.getValue()>=freq){
                if(m.getValue()==freq){
                    if(m.getKey()<maxi) maxi=m.getKey();
                    continue;
                }
                maxi=m.getKey();
                freq=m.getValue();
            }
        }
        return maxi;
    }
}