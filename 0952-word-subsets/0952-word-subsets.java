class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        HashMap<Character,Integer> primary=new HashMap();
        for(String s:words2){
            HashMap<Character,Integer> temp=new HashMap();
            for(char c:s.toCharArray()){
                temp.put(c,temp.getOrDefault(c,0)+1);
            }
            for(Map.Entry<Character,Integer> m:temp.entrySet()){
                if(!primary.containsKey(m.getKey()) || m.getValue()>primary.get(m.getKey())){
                    primary.put(m.getKey(),m.getValue());
                }
            }
        }
        List<String> list=new ArrayList();
        for(String s:words1){
            HashMap<Character,Integer> hs=new HashMap();
            for(char c:s.toCharArray()){
                hs.put(c,hs.getOrDefault(c,0)+1);
            }
            int flag=0;
            for(Map.Entry<Character,Integer> m:primary.entrySet()){
                if(!hs.containsKey(m.getKey())){
                    flag=1;
                    break;
                }
                if(m.getValue()>hs.get(m.getKey())){
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                list.add(s);
            }
        }
        return list;
    }
}