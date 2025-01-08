class Solution {
    int ans=0;
    public int countPrefixSuffixPairs(String[] words) {
        for(int i=0;i<words.length-1;i++){
            String s=words[i];
            for(int j=i+1;j<words.length;j++){
                String a=words[j];
                if(pip(s,a)){
                    ans++;
                }
            }
        }
        return ans;
    }
    boolean pip(String s,String a){
        if(s.length()>a.length()){
            return false;
        }
        if(s.length()==a.length() && s.equals(a)){
            return true;
        }
        if(a.startsWith(s) && a.endsWith(s)){
            return true;
        }
        return false;
    }
}