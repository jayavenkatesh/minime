class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> hm=new HashMap();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            hm.put(c,i);
        }
        List<Integer> list=new ArrayList();
        int maxi=(int) (-1e9);
        int size=0;
        for(int i=0;i<s.length();i++){
            size++;
            char c=s.charAt(i);
            maxi=Math.max(maxi,hm.get(c));
            if(i==maxi){
                list.add(size);
                size=0;
            }
        }
        return list;
    }
}