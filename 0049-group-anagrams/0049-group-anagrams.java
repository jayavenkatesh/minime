class Solution {
    List<List<String>> ans=new ArrayList();
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<String> qn=new ArrayList();
        for(String s:strs){
            qn.add(s);
        }
        while(!qn.isEmpty()){
            List<String> list=new ArrayList();
            String str=qn.get(0);
            list.add(str);
            qn.remove(str);
            char[] arr=new char[26];
            for(char c:str.toCharArray()){
                arr[c-'a']++;
            }
            // if(qn.isEmpty()){
            //     ans.add(new ArrayList(list));
            //     break;
            // }
            for(int i=0;i<qn.size();i++){
                String s=qn.get(i);
                char[] temp=new char[26];
                for(char c:s.toCharArray()){
                    temp[c-'a']++;
                }
                if(Arrays.equals(arr,temp)){
                    list.add(s);
                    qn.remove(s);
                    i--;
                }
            }
            ans.add(new ArrayList(list));
        }
        return ans;
    }
}