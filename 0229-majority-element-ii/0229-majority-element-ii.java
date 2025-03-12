class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList();
        HashMap<Integer,Integer> hm=new HashMap();
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> m:hm.entrySet()){
            if(m.getValue()>(nums.length/3)) ans.add(m.getKey());
        }
        return ans;
    }
}