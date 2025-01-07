class Solution {
    public List<String> stringMatching(String[] words) {
        HashSet<String> hs=new HashSet();
        List<String> list=new ArrayList();
        for(int i=0;i<words.length;i++){
            String s=words[i];
            for(int j=0;j<words.length;j++){
                if(i==j){
                    continue;
                }
                String a=words[j];
                if(s.contains(a) && !hs.contains(a)){
                    list.add(a);
                    hs.add(a);
                }
            }
        }
        return list;
    }
}