class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        HashMap<Character,Integer> hm1=new HashMap();
        HashMap<Character,Integer> hm2=new HashMap();
        int f=0;
        for(int i=0;i<s1.length();i++){
            hm1.put(s1.charAt(i),hm1.getOrDefault(s1.charAt(i),0)+1);
            hm2.put(s2.charAt(i),hm2.getOrDefault(s2.charAt(i),0)+1);
            if(s1.charAt(i)!=s2.charAt(i)){
                f++;
            }
        }
        if(!hm1.equals(hm2)) return false;
        return f>2?false:true;
    }
}